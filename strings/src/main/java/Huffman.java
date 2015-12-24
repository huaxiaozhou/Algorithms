import com.huazhou.std.BinaryStdIn;
import com.huazhou.std.BinaryStdOut;
import com.huazhou.utils.MinPQ;

/**
 * Created by huazhou on 2015/12/24.
 */
public class Huffman {
    //ASCII字母表
    private static final int R = 256;

    //霍夫曼单词查找树中的结点
    private static class Node implements Comparable<Node> {
        //叶子结点中需要被编码的字符
        private final char ch;  //内部结点不会使用该变量
        private final int freq; //展开过程不会使用该变量
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        private boolean isLeaf() {
            return (left == null) && (right == null);
        }

        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    //压缩
    public static void compress() {
        //读取输入
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();

        //统计频率
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++) {
            freq[input[i]]++;
        }

        //构造霍夫曼编码树
        Node root = buildTrie(freq);

        //（递归地）构造编译表
        String[] st = new String[R];
        buildCode(st, root, "");

        //（递归地）打印解码用的单词查找树
        writeTrie(root);

        //打印字符总数
        BinaryStdOut.write(input.length);

        //使用霍夫曼编码处理输入
        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0') {
                    BinaryStdOut.write(false);
                }
                else if (code.charAt(j) == '1') {
                    BinaryStdOut.write(true);
                }
                else throw new IllegalStateException("Illegal state");
            }
        }
        //
        BinaryStdOut.close();
    }

    //展开
    public static void expand() {
        Node root = readTrie();

        int length = BinaryStdIn.readInt();
        //展开第i个编码所对应的字母
        for (int i = 0; i < length; i++) {
            Node x = root;
            while (!x.isLeaf()) {
                boolean bit = BinaryStdIn.readBoolean();
                if (bit) {
                    x = x.right;
                }
                else {
                    x = x.left;
                }
            }
            BinaryStdOut.write(x.ch);
        }
        BinaryStdOut.close();
    }

    //从比特流的前序表示中重建单词查找树
    private static Node readTrie() {
        boolean isLeaf = BinaryStdIn.readBoolean();
        if (isLeaf) {
            return new Node(BinaryStdIn.readChar(), 0, null, null);
        }
        return new Node('\0', 0, readTrie(), readTrie());
    }

    //使用单词查找树构造编译表
    private static String[] buildCode(Node root){
        String[] st = new String[R];
        buildCode(st, root, "");
        return st;
    }

    //使用单词查找树构造编译表（递归）
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.ch] = s;
        }
    }

    //构造一棵霍夫曼编码单词查找树
    private static Node buildTrie(int[] freq) {
        //使用多棵单结点树初始化优先队列
        MinPQ<Node> pq = new MinPQ<Node>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0) {
                pq.insert(new Node(i, freq[i], null, null));
            }

        //合并两棵频率最小的树
        while (pq.size() > 1) {
            Node left  = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    //输出单词查找树的比特字符串
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }
}
