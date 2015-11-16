import com.huazhou.utils.Model;

/**
 * 算法2.1 选择排序
 * @author huazhou
 *
 */
public class Selection extends Model{
	//将a[]按升序排列
	public void sort(Comparable[] a){
//		System.out.println("Selection");
		int N = a.length;	//数组长度
		//将a[i]和a[i+1...N]中最小的元素交换
		for (int i = 0; i < N; i++) {
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
