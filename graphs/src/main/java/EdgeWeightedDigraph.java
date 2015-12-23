import com.huazhou.std.In;
import com.huazhou.utils.Bag;

/**
 * ��Ȩ����ͼ����������
 * Created by huazhou on 2015/12/20.
 */
public class EdgeWeightedDigraph {
    private int V;              //��������
    private int E;              //�ߵ�����
    private Bag<DirectedEdge>[] adj;    //�ڽӱ�

    //����V������Ŀ�����ͼ
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

    //��������
    public int V() {
        return V;
    }

    //�ߵ�����
    public int E() {
        return E;
    }

    //��e��ӵ�������ͼ��
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
        E++;
    }

    //��vָ���ı�
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    //������ͼ�е����б�
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
