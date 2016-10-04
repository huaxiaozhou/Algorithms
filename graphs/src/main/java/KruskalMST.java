import com.huazhou.std.In;
import com.huazhou.std.StdOut;
import com.huazhou.utils.MinPQ;
import com.huazhou.utils.Queue;
import com.huazhou.utils.UF;

/**
 * 最小生成树的Kruskal算法
 * Created by huazhou on 2015/12/19.
 */
public class KruskalMST {
    private Queue<Edge> mst;

//    public KruskalMST(EdgeWeightedGraph G) {
//        mst = new Queue<Edge>();
//        MinPQ<Edge> pq = new MinPQ<Edge>(G.edges());
//        UF uf = new UF(G.V());
//
//        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
//            Edge e = pq.delMin();//从pq得到权重最小的边和它的顶点
//            int v = e.either();
//            int w = e.other(v);
//            //忽略失效的边
//            if (uf.connected(v, w)) {
//                continue;
//            }
//            uf.union(v, w);  //合并分量
//            mst.enqueue(e);  //将边添加到最小生成树中
//        }
//    }

    public Iterable<Edge> edges() {
        return mst;
    }

//    public static void main(String[] args) {
//        In in = new In(args[0]);
//        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
//        KruskalMST mst = new KruskalMST(G);
//        for (Edge e : mst.edges()) {
//            StdOut.println(e);
//        }
////        StdOut.printf("%.5f\n", mst.weight());
//    }
}
