import com.huazhou.std.StdIn;
import com.huazhou.std.StdOut;
import com.huazhou.utils.ST;

public class Example {
    public static void main(String[] args) {
        ST<String, Integer> st;
        st = new ST<String, Integer>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
