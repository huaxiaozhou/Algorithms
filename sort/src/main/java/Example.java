import com.huazhou.std.In;
import com.huazhou.utils.Model;

public class Example {
    //从标准输入读取字符串，将它们排序并输出
    public static void main(String[] args){
//		Model model = new Selection();
//        Model model = new Insertion();
//        Model model = new Shell();
//        Model model = new Merge();
//        Model model = new MergeX();
//        Model model = new Quick();
        Model model = new Heap();

        String[] a = In.readStrings();
        model.sort(a);
        assert model.isSorted(a);
        model.show(a);
    }
}
