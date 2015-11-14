package com.huazhou.utils;
import com.huazhou.std.StdOut;

/**
 * 排序算法类模板
 */
public class Model {
	public void sort(Comparable[] a){
		//排序算法的具体实现
	}

	//对元素进行比较，如果v比w小则返回true
	protected boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}

	//将元素交换位置
	protected void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	//在单行中打印数组
	public void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	//测试数组元素是否有序
	public boolean isSorted(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			if(less(a[i], a[i-1])){
				return false;
			}
		}
		return true;
	}
}
