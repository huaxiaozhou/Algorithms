import com.huazhou.utils.Insertion;

/**
 * 算法5.2 高位优先的字符串排序
 * Created by huazhou on 2015/12/22.
 */
public class MSD {
    private static int R = 256;   //基数
    private static final int M = 15;    //小数组的切换阀值
    private static String[] aux;    //数据分类的辅助数组

    private static int charAt(String s, int d){
        if(d < s.length()){
            return s.charAt(d);
        }
        else{
            return -1;
        }
    }

    public static void sort(String[] a){
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
    }

    //以第d个字符为键将a[lo]至a[hi]排序
    private static void sort(String[] a, int lo, int hi, int d){
        if(hi <= lo + M){
//            Insertion.sort(a, lo, hi, d);
            return;
        }
        int[] count = new int[R+2]; //计算频率
        for (int i = lo; i <= hi; i++){
            count[charAt(a[i], d) + 2]++;
        }
        for (int r = 0; r < R+1; r++){//将频率转换为索引
            count[r+1] += count[r];
        }
        for (int i = lo; i <= hi; i++){ //数据分类
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++){ //回写
            a[i] = aux[i - lo];
        }

        //递归的以每个字符为键进行排序
        for (int r = 0; r < R; r++){
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1);
        }
    }
}
