import com.huazhou.std.In;
import com.huazhou.std.StdOut;

/**
 * Created by huazhou on 2015/12/6.
 */
public class TestSearch {
    public static void main(String[] args){
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
//        DepthFirstSearch search = new DepthFirstSearch(G, s);
//        Paths search = new Paths(G, s);
        DepthFirstSearch search = new DepthFirstSearch(G,s);
//        BreadthFirstPaths search = new BreadthFirstPaths(G,s);
//        testConnected(search, G);
        findAllPaths(search, G, s);
    }

    private static void findAllPaths(DepthFirstSearch search, Graph G, int s){
        for(int v = 0; v < G.V(); v++){
            StdOut.print(s + " to " + v + ": ");
            if(search.hasPathTo(v)){
                for (int x : search.pathTo(v)){
                    if(x == s){
                        StdOut.print(x);
                    }
                    else{
                        StdOut.print("-" + x);
                    }
                }
            }
            StdOut.println();
        }
    }

    private static void testConnected(
            DepthFirstSearch search, Graph G){
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
