import com.huazhou.utils.Model;

/**
 * Ëã·¨2.7 ¶ÑÅÅÐò
 * Created by huazhou on 2015/11/23.
 */
public class Heap extends Model {

    public void sort(Comparable[] pq) {
        int N = pq.length;
        for (int k = N/2; k >= 1; k--)
            sink(pq, k, N);
        while (N > 1) {
            exch(pq, 1, N--);
            sink(pq, 1, N);
        }
    }

    private void sink(Comparable[] pq, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    protected void exch(Comparable[] pq, int i, int j) {
        Comparable swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
}
