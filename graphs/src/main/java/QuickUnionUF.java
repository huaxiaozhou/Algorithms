/**
 * Created by huazhou on 2015/12/6.
 */
public class QuickUnionUF {
    private int[] id;   //分量id（以触点作为索引）
    private int count;  //分量数量

    //初始化分量id数组
    public QuickUnionUF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    //找出分量的名称
    public int find(int p){
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }

    //将p和q的根节点统一
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        return count;
    }
}
