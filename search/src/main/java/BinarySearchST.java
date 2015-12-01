import com.huazhou.utils.Queue;

/**
 * 算法3.2 二分查找（基于有序数组）
 * Created by huazhou on 2015/11/29.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity){
        keys = (Key[])new Comparable[capacity];
        vals = (Value[])new Object[capacity];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key){
        if(isEmpty()){
            return null;
        }
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            return vals[i];
        }
        else{
            return null;
        }
    }

    public int rank(Key key){
        int lo = 0, hi = N-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0){
                hi = mid - 1;
            }
            else if(cmp > 0){
                lo = mid + 1;
            }
            else{
                return mid;
            }
        }
        return lo;
    }

    //查找键，找到则更新值，否则创建新的元素
    public void put(Key key, Value val){
        if(val == null){
            delete(key);
            return;
        }
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }
        if(N == keys.length){
            resize(2*keys.length);
        }
        for (int j = N; j > i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public void delete(Key key){
        if (isEmpty()) return;

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < N-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        N--;
        keys[N] = null;  // to avoid loitering
        vals[N] = null;

        // resize if 1/4 full
        if (N > 0 && N == keys.length/4) resize(keys.length/2);
    }

    private void resize(int capacity) {
        assert capacity >= N;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N-1];
    }

    public Key select(int k){
        return keys[k];
    }

    public Key ceiling(Key key){
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key){
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> q = new Queue<Key>();
        if(lo.compareTo(hi) > 0){
            return q;
        }
        for (int i = rank(lo); i < rank(hi); i++){
            q.enqueue(keys[i]);
        }
        if(contains(hi)){
            q.enqueue(keys[rank(hi)]);
        }
        return q;
    }

}
