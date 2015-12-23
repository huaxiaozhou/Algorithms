/**
 * 加权有向边的数据类型
 * Created by huazhou on 2015/12/20.
 */
public class DirectedEdge {
    private int v;          //边的起点
    private int w;          //边的终点
    private double weight;  //边的权重

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //边的权重
    public double weight() {
        return weight;
    }

    //指出这条边的顶点
    public int from() {
        return v;
    }


    //这条边指向的顶点
    public int to() {
        return w;
    }

    public String toString() {
        return v + "->" + w + " " + String.format("%5.2f", weight);
    }
}
