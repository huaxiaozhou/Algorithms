import com.huazhou.utils.Model;

/**
 * 选择排序
 * @author huazhou
 *
 */
public class Selection extends Model{

	public void sort(Comparable[] a){
		System.out.println("Selection sort");
		//将a[]按升序排列
		int N = a.length;
		for (int i = 0; i < N; i++) {
			//将a[i]和a[i+1...N]中最小的元素交换
			int min = i;		//最小元素的索引
			for (int j = i+1; j < N; j++) {
				if(less(a[j], a[min])){
					min = j;
				}
			}
			exch(a, i, min);
		}
	}
}
