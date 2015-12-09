import com.huazhou.utils.Queue;
import com.huazhou.utils.Stack;


/**
 * �㷨4.2 ʹ�ù��������������ͼ�е�·��
 * Created by huazhou on 2015/12/9.
 */
public class BreadthFirstPaths {
    private boolean[] marked;   //����ö�������·����֪��
    private int[] edgeTo;   //����ö������֪·���ϵ����һ������
    private int s;  //���

    public BreadthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;   //������
        queue.enqueue(s);   //�����������
        while(!queue.isEmpty()){
            int v = queue.dequeue();    //�Ӷ�����ɾȥ��һ����
            for (int w : G.adj(v)){
                //����ÿ��δ����ǵ����ڶ���
                if(!marked[w]){
                    edgeTo[w] = v;  //�������·�������һ����
                    marked[w] = true;   //���������Ϊ���·����֪
                    queue.enqueue(w);   //��������ӵ�������
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
