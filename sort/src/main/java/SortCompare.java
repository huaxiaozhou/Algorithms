import com.huazhou.std.StdOut;
import com.huazhou.std.StdRandom;
import com.huazhou.utils.Stopwatch;

/**
 * 比较两种排序算法
 * @author huazhou
 *
 */
public class SortCompare {
	public static double time(String alg, Comparable[] a){
		Selection selection = new Selection();
		Insertion insertion = new Insertion();

		Stopwatch timer = new Stopwatch();
		if(alg.equals("Selection")){
			selection.sort(a);
		}
		if(alg.equals("Insertion")){
			insertion.sort(a);
		}
		return timer.elapsedTime();
	}

	public static double timeRandomInput(String alg, int N, int T){
		//使用算法1将T个长度为N的数组排序
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {
			//进行一次测试(生成一个数组并排序)
			for (int i = 0; i < N; i++) {
				a[i] = StdRandom.uniform();
			}
			total += time(alg, a);
		}
		return total;
	}

	public static void main(String[] args){
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T);//算法1的总时间
		double t2 = timeRandomInput(alg2, N, T);//算法2的总时间
		StdOut.printf("For %d random Doubles\n	%s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
	}
}
