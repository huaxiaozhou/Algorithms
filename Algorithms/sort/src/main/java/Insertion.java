import com.huazhou.utils.Model;

/**
 * 插入排序
 * @author huazhou
 *
 */
public class Insertion extends Model{

	public void sort(Comparable[] a){
		System.out.println("Insertion sort");
		//将a[]按升序排列
		int N = a.length;
		for (int i = 0; i < N; i++) {
			//将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}
}
