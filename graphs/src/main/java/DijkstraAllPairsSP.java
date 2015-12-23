/**
 * 任意顶点对之间的最短路径
 * Created by huazhou on 2015/12/20.
 */
public class DijkstraAllPairsSP {
    private DijkstraSP[] all;

    public DijkstraAllPairsSP(EdgeWeightedDigraph G) {
        all  = new DijkstraSP[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DijkstraSP(G, v);
        }
    }

    public Iterable<DirectedEdge> path(int s, int t) {
        return all[s].pathTo(t);
    }

    public double dist(int s, int t) {
        return all[s].distTo(t);
    }

    public boolean hasPath(int s, int t) {
        return dist(s, t) < Double.POSITIVE_INFINITY;
    }
}
