import com.huazhou.utils.Queue;

/**
 * 算法3.6 基于线性探测的符号表
 * Created by huazhou on 2015/12/5.
 */
public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;
    private int N;  //符号表中键值对的总数
    private int M;   //线性探测表的大小
    private Key[] keys; //键
    private Value[] vals;   //值

    public LinearProbingHashST(){
        this(INIT_CAPACITY);
    }

    public LinearProbingHashST(int capacity){
        M = capacity;
        keys = (Key[])new Object[M];
        vals = (Value[])new Object[M];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capacity){
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        M    = temp.M;
    }

    public void put(Key key, Value val){
        if(N >= M/2){
            resize(2*M);    //将M加倍
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i+1)%M){
            if(keys[i].equals(key)){
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key){
        for (int i = hash(key); keys[i] != null; i = (i+1)%M){
            if(keys[i].equals(key)){
                return vals[i];
            }
        }
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

}
