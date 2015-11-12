package com.huazhou.utils;
import com.huazhou.std.StdOut;

/**
 * 排序算法模板
 */
public class Model {
	public void sort(Comparable[] a){
		
	}
	
	protected boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	protected void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public void show(Comparable[] a){
		//在单行中打印数组
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public boolean isSorted(Comparable[] a){
		//测试数组元素是否有序
		for (int i = 0; i < a.length; i++) {
			if(less(a[i], a[i-1])){
				return false;
			}
		}
		return true;
	}
}
