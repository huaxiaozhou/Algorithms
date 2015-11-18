import com.huazhou.utils.Model;

/**
 * 自顶向下的归并排序
 * @author huazhou
 *
 */
public class Merge extends Model{
	private Comparable[] aux;	//归并所需的辅助数组

	public void sort(Comparable[] a){
//		System.out.println("Merge");
		aux = new Comparable[a.length];	//一次性分配空间
		sort(a, 0, a.length - 1);
	}

	//将数组a[lo..hi]排序
	private void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo){
			return;
		}
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);	//将左半边排序
		sort(a, mid+1, hi);	//将右半边排序
		merge(a, lo, mid, hi);	//归并结果
	}

	/**
	 * 原地归并的抽象方法
	 * 将a[lo..mid]和a[mid+1..hi]归并
	 */
	public void merge(Comparable[] a, int lo, int mid, int hi){
		int i = lo, j = mid+1;
		//将a[lo..hi]复制到aux[lo..hi]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		//归并回到a[lo..hi]
		for (int k = lo; k <= hi; k++) {
			if(i > mid){
				a[k] = aux[j++];
			}
			else if(j > hi){
				a[k] = aux[i++];
			}
			else if(less(aux[j], aux[i])){
				a[k] = aux[j++];
			}
			else{
				a[k] = aux[i++];
			}
		}
	}
}
