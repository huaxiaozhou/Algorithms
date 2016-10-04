import com.huazhou.utils.IndexMinPQ;
import com.huazhou.utils.Queue;

/**
 * 最小生成树的Prim算法（即时版本）
 * Created by huazhou on 2015/12/19.
 */
public class PrimMST {
    private Edge[] edgeTo;  //距离树最近的边
    private double[] distTo;  //distTo[w]=edgeTo[w].weight()
    private boolean[] marked;  //如果v在树中则为true
    private IndexMinPQ<Double> pq;  //有效的横切边

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0.0;
        pq.insert(0, 0.0);//用顶点0和权重0初始化pq
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            visit(G, v);    //将最近的顶点添加到树中
        }
    }

    //将顶点v添加到树中，更新数据
    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {
                continue;    //v-w失效
            }
            //连接w和树的最佳边Edge变为e
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                }
                else{
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }
}
