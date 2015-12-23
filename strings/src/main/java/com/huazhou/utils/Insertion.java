package com.huazhou.utils;

import com.huazhou.utils.Model;

/**
 * 算法2.2 插入排序
 * @author huazhou
 *
 */
public class Insertion extends Model{
	//将a[]按升序排列
	public void sort(Comparable[] a){
//		System.out.println("Insertion");
		int N = a.length;
		//将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}
}
