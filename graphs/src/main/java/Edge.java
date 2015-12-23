/**
 * 带权重的边的数据类型
 * Created by huazhou on 2015/12/17.
 */
public class Edge implements Comparable<Edge>{
    private int v;  //顶点之一
    private int w;  //另一个顶点
    private double weight;  //边的权重

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    //已知一个顶点v时，可以得到边的另一个顶点
    public int other(int vertex) {
        if (vertex == v) {
            return w;
        }
        else if (vertex == w) {
            return v;
        }
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight() < that.weight()) {
            return -1;
        }
        else if (this.weight() > that.weight()) {
            return +1;
        }
        else {
            return  0;
        }
    }

    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }
}
