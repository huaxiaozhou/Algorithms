import com.huazhou.std.In;
import com.huazhou.std.StdOut;
import com.huazhou.utils.MinPQ;
import com.huazhou.utils.Queue;
import com.huazhou.utils.UF;

/**
 * ��С��������Kruskal�㷨
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
//            Edge e = pq.delMin();//��pq�õ�Ȩ����С�ıߺ����Ķ���
//            int v = e.either();
//            int w = e.other(v);
//            //����ʧЧ�ı�
//            if (uf.connected(v, w)) {
//                continue;
//            }
//            uf.union(v, w);  //�ϲ�����
//            mst.enqueue(e);  //������ӵ���С��������
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
