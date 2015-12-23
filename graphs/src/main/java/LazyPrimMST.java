import com.huazhou.utils.MinPQ;
import com.huazhou.utils.Queue;

/**
 * 最小生成树的Prim算法的延时实现
 * Created by huazhou on 2015/12/18.
 */
public class LazyPrimMST {
    private Queue<Edge> mst;     //最小生成树的边
    private boolean[] marked;    //最小生成树的顶点
    private MinPQ<Edge> pq;     //横切边（包括失效的边）

    public LazyPrimMST(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];

        visit(G, 0);    //假设G是连通的
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();          //从pq中得到权重最小的边
            int v = e.either(), w = e.other(v);  //跳过失效的边
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.enqueue(e);            //将边添加到树中
            if (!marked[v]) {   //将顶点（v或w）添加到树中
                visit(G, v);
            }
            if (!marked[w]) {
                visit(G, w);
            }
        }
    }

    //标记顶点v并将所有连接v和未被标记顶点的边加入pq
    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
