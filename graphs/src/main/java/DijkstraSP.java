import com.huazhou.utils.IndexMinPQ;
import com.huazhou.utils.Stack;

/**
 * �㷨4.9 ���·����Dijkstra�㷨
 * Created by huazhou on 2015/12/20.
 */
public class DijkstraSP {
    //�����s��v����֪���·���ĳ���
    private double[] distTo;
    //�����s��v�����·���ϵ����һ����
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int v = 0; v < G.V(); v++) {
            //��ʼ��Ϊ�������
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    //������ɳ�
    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                }
                else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    //�ߵ��ɳ�
    private void relax(DirectedEdge e){
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

    //���·����ʵ���еı�׼��ѯ�㷨
    public double distTo(int v) {
        return distTo[v];
    }

    //
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}
