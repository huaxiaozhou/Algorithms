import com.huazhou.utils.Queue;
import com.huazhou.utils.Stack;

/**
 * ����ͼ�л���������������Ķ�������
 * Created by huazhou on 2015/12/14.
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> preorder;   //���ж����ǰ������
    private Queue<Integer> postorder;  //���ж���ĺ�������
    private Stack<Integer> reversePost;//���ж�������������

    public DepthFirstOrder(Digraph G) {
        postorder = new Queue<Integer>();
        preorder  = new Queue<Integer>();
        marked    = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        preorder.enqueue(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return preorder;
    }

    public Iterable<Integer> post() {
        return postorder;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
