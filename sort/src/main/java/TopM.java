import java.util.Stack;

import com.huazhou.std.StdIn;
import com.huazhou.std.StdOut;
import com.huazhou.utils.MinPQ;
import com.huazhou.utils.Transaction;

/**
 * 一个优先队列的用例
 */
public class TopM {

	//打印输入流中最大的M行
	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1);
		//为下一行输入创建一个元素并放入优先队列中
		while(StdIn.hasNextLine()){
			pq.insert(new Transaction(StdIn.readLine()));
			if(pq.size() > M){
				pq.delMin();//如果优先队列中存在M+1个元素则删除其中最小的元素
			}	//最大的M个元素都在优先队列中

			Stack<Transaction> stack = new Stack<Transaction>();
			while(!pq.isEmpty()){
				stack.push(pq.delMin());
			}
			for (Transaction t : stack) {
				StdOut.println(t);
			}
		}
	}
}
