import com.huazhou.std.In;
import com.huazhou.std.StdOut;
import com.huazhou.utils.Bag;

/**
 * 无向图数据结构
 * Created by huazhou on 2015/12/6.
 */
public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private int V;    //顶点数目
    private int E;  //边的数目
    private Bag<Integer>[] adj; //邻接表

    //创建一个含有V个顶点但不含有边的图
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[])new Bag[V];   //创建邻接表
        //将所有链表初始化为空
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    //从标准输入流in读入一幅图
    public Graph(In in){
        this(in.readInt()); //读取V并将图初始化
        int E = in.readInt();   //读取E
        //添加一条边
        for (int i = 0; i < E; i++){
            int v = in.readInt();   //读取一个顶点
            int w = in.readInt();   //读取另一个顶点
            addEdge(v, w);  //添加一条连接它们的边
        }
    }

    //顶点数
    public int V(){
        return V;
    }

    //边数
    public int E(){
        return E;
    }

    //向图中添加一条边v-w
    public void addEdge(int v, int w){
        adj[v].add(w);  //将w添加到v的链表中
        adj[w].add(v);  //将v添加到w的链表中
        E++;
    }

    //和v相邻的所有顶点
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }
}
