import com.huazhou.std.In;
import com.huazhou.utils.Model;

public class Example {
    public static void main(String[] args){
//		Model model = new Selection();
        Model model = new Insertion();

        //从标准输入读取字符串，将它们排序并输出
        String[] a = In.readStrings();
        model.sort(a);
        assert model.isSorted(a);
        model.show(a);
    }
}
