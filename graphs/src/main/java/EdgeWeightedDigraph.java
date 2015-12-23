import com.huazhou.std.In;
import com.huazhou.utils.Bag;

/**
 * 加权有向图的数据类型
 * Created by huazhou on 2015/12/20.
 */
public class EdgeWeightedDigraph {
    private int V;              //顶点总数
    private int E;              //边的总数
    private Bag<DirectedEdge>[] adj;    //邻接表

    //含有V个顶点的空有向图
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<DirectedEdge>();
        }
    }

    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    //顶点总数
    public int V() {
        return V;
    }

    //边的总数
    public int E() {
        return E;
    }

    //将e添加到该有向图中
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
        E++;
    }

    //从v指出的边
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    //该有向图中的所有边
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> list = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    }
}
