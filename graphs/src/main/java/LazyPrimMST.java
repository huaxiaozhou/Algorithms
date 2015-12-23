import com.huazhou.utils.MinPQ;
import com.huazhou.utils.Queue;

/**
 * ��С��������Prim�㷨����ʱʵ��
 * Created by huazhou on 2015/12/18.
 */
public class LazyPrimMST {
    private Queue<Edge> mst;     //��С�������ı�
    private boolean[] marked;    //��С�������Ķ���
    private MinPQ<Edge> pq;     //���бߣ�����ʧЧ�ıߣ�

    public LazyPrimMST(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];

        visit(G, 0);    //����G����ͨ��
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();          //��pq�еõ�Ȩ����С�ı�
            int v = e.either(), w = e.other(v);  //����ʧЧ�ı�
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.enqueue(e);            //������ӵ�����
            if (!marked[v]) {   //�����㣨v��w����ӵ�����
                visit(G, v);
            }
            if (!marked[w]) {
                visit(G, w);
            }
        }
    }

    //��Ƕ���v������������v��δ����Ƕ���ı߼���pq
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
