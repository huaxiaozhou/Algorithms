import com.huazhou.utils.Stack;

/**
 * 算法4.1 深度优先搜索
 * Created by huazhou on 2015/12/8.
 */
public class DepthFirstSearch {
    private boolean[] marked;   //这个顶点上调用过dfs()了吗？
    private int count;
    private int[] edgeTo;   //从起点到一个顶点的已知路径上的最后一个顶点
    private int s;    //起点

    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        count++;
        for (int w : G.adj(v)){
            if(!marked[w]){
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
