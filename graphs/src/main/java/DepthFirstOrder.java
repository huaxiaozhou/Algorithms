import com.huazhou.utils.Queue;
import com.huazhou.utils.Stack;

/**
 * 有向图中基于深度优先搜索的顶点排序
 * Created by huazhou on 2015/12/14.
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> preorder;   //所有顶点的前序排列
    private Queue<Integer> postorder;  //所有顶点的后序排列
    private Stack<Integer> reversePost;//所有顶点的逆后序排列

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
