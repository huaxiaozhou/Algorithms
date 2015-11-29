import com.huazhou.std.StdIn;
import com.huazhou.std.StdOut;
import com.huazhou.utils.ST;

/**
 * 符号表用例
 */
public class FrequencyCounter {

	public static void main(String[] args) {
		int minlen = Integer.parseInt(args[0]);	//最小键长
//		ST<String, Integer> st = new ST<String, Integer>();
		SequentialSearchST<String, Integer> st =
				new SequentialSearchST<String, Integer>();

		//构造符号表并统计频率
		while(!StdIn.isEmpty()){
			String word = StdIn.readString();
			//忽略较短的单词
			if(word.length() < minlen){
				continue;
			}
			if(!st.contains(word)){
				st.put(word, 1);
			}
			else{
				st.put(word, st.get(word) + 1);
			}
		}
		//找出出现频率最高的单词
		String max = " ";
		st.put(max, 0);
		for (String word : st.keys()) {
			if(st.get(word) > st.get(max)){
				max = word;
			}
		}
		StdOut.println(max + " " + st.get(max));
	}
}
