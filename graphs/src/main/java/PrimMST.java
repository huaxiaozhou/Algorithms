import com.huazhou.utils.IndexMinPQ;
import com.huazhou.utils.Queue;

/**
 * ��С��������Prim�㷨����ʱ�汾��
 * Created by huazhou on 2015/12/19.
 */
public class PrimMST {
    private Edge[] edgeTo;  //����������ı�
    private double[] distTo;  //distTo[w]=edgeTo[w].weight()
    private boolean[] marked;  //���v��������Ϊtrue
    private IndexMinPQ<Double> pq;  //��Ч�ĺ��б�

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0.0;
        pq.insert(0, 0.0);//�ö���0��Ȩ��0��ʼ��pq
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            visit(G, v);    //������Ķ�����ӵ�����
        }
    }

    //������v��ӵ����У���������
    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {
                continue;    //v-wʧЧ
            }
            //����w��������ѱ�Edge��Ϊe
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
