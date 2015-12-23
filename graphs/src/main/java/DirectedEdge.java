/**
 * ��Ȩ����ߵ���������
 * Created by huazhou on 2015/12/20.
 */
public class DirectedEdge {
    private int v;          //�ߵ����
    private int w;          //�ߵ��յ�
    private double weight;  //�ߵ�Ȩ��

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //�ߵ�Ȩ��
    public double weight() {
        return weight;
    }

    //ָ�������ߵĶ���
    public int from() {
        return v;
    }


    //������ָ��Ķ���
    public int to() {
        return w;
    }

    public String toString() {
        return v + "->" + w + " " + String.format("%5.2f", weight);
    }
}
