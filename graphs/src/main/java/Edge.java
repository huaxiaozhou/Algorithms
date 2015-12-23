/**
 * ��Ȩ�صıߵ���������
 * Created by huazhou on 2015/12/17.
 */
public class Edge implements Comparable<Edge>{
    private int v;  //����֮һ
    private int w;  //��һ������
    private double weight;  //�ߵ�Ȩ��

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

    //��֪һ������vʱ�����Եõ��ߵ���һ������
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
