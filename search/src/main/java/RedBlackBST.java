import com.huazhou.utils.Queue;

import java.util.NoSuchElementException;

/**
 * 算法3.4 红黑树
 * Created by huazhou on 2015/12/2.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private final boolean RED = true;
    private final boolean BLACK = false;

    private class Node{
        Key key;    //键
        Value val;  //相关联的值
        Node left, right;   //左右子树
        int N;  //这棵子树中的结点总数
        boolean color;  //由其父结点指向它的链接的颜色

        Node(Key key, Value val, int N, boolean color){
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if(x == null){
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null){
            return 0;
        }
        else{
            return x.N;
        }
    }

    //查找key，找到则更新其值，否则为它新建一个结点
    public void put(Key key, Value val){
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val){
        //标准的插入操作，和父结点用红链接相连
        if(h == null){
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if(cmp < 0){
            h.left = put(h.left, key, val);
        }
        else if(cmp > 0){
            h.right = put(h.right, key, val);
        }
        else{
            h.val = val;
        }
        if(isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }

    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue<Key>();
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new NullPointerException("first argument to keys() is null");
        if (hi == null) throw new NullPointerException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        // assert x != null;
        if (x.left == null) return x;
        else                return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        // assert x != null;
        if (x.right == null) return x;
        else                 return max(x.right);
    }
}
