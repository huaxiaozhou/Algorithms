import com.huazhou.utils.Queue;

/**
 * 算法3.1 顺序查找（基于无序链表）
 * Created by huazhou on 2015/11/11.
 */
public class SequentialSearchST<Key, Value> {
    private int N;
    private Node first; //链表首结点
    //链表结点的定义
    private class Node{
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    //查找给定的键，返回相关联的值
    public Value get(Key key){
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key)){
                return x.val;   //命中
            }
        }
        return null;    //未命中
    }

    //查找给定的键，找到则更新其值，否则在表中新建结点
    public void put(Key key, Value val){
        for (Node x = first; x != null; x = x.next){
            if(key.equals(x.key)){  //命中，更新
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);  //未命中，新建结点
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("argument to contains() is null");
        return get(key) != null;
    }

    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }
}
