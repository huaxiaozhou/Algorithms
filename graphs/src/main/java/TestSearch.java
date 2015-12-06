import com.huazhou.std.In;
import com.huazhou.std.StdOut;

/**
 * Created by huazhou on 2015/12/6.
 */
public class TestSearch {
    public static void main(String[] args){
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Search search = new Search(G, s);

        for (int v = 0; v < G.V(); v++){
            if(search.marked(v)){
                StdOut.print(v+" ");
            }
        }
        StdOut.println();

        if(search.count() != G.V()){
            StdOut.print("NOT ");
        }
        StdOut.println("connected");
    }
}
