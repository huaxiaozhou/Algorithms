import com.huazhou.utils.Queue;

/**
 * 算法3.5 基于拉链法的散列表
 * Created by huazhou on 2015/12/5.
 */
public class SeparateChainingHashST<Key, Value> {
    private int N;  //键值对总数
    private int M;  //散列表的大小
    private SequentialSearchST<Key, Value>[] st;//存放链表对象的数组

    public SeparateChainingHashST(){
        this(997);
    }
    //创建M条链表
    public SeparateChainingHashST(int M){
        this.M = M;
        st = (SequentialSearchST<Key, Value>[])
                new SequentialSearchST[M];
        for (int i = 0; i < M; i++){
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key){
        return (Value)st[hash(key)].get(key);
    }

    public void put(Key key, Value val){
        st[hash(key)].put(key, val);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }
}
