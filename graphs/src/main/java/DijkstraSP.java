import com.huazhou.utils.IndexMinPQ;
import com.huazhou.utils.Stack;

/**
 * 算法4.9 最短路径的Dijkstra算法
 * Created by huazhou on 2015/12/20.
 */
public class DijkstraSP {
    //从起点s到v的已知最短路径的长度
    private double[] distTo;
    //从起点s到v的最短路径上的最后一条边
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int v = 0; v < G.V(); v++) {
            //初始化为正无穷大
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    //顶点的松弛
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

    //边的松弛
    private void relax(DirectedEdge e){
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

    //最短路径树实现中的标准查询算法
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
