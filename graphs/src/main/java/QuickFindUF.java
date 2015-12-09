/**
 * Created by huazhou on 2015/12/7.
 */
public class QuickFindUF {
    private int[] id;   //分量id（以触点作为索引）
    private int count;  //分量数量

    //初始化分量id数组
    public QuickFindUF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    //找出分量的名称
    public int find(int p){
        return id[p];
    }

    //将p和q归并到相同的分量中
    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        //如果p和q已经在相同的分量之中则不需要采取任何行动
        if(pID == qID){
            return;
        }
        //将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
        count--;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        return count;
    }
}
