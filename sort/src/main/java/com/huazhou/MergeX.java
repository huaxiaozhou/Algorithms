package com.huazhou;

import com.huazhou.utils.Model;

/**
 * Created by huazhou on 2015/11/21.
 */
public class MergeX extends Model{
    // cutoff to insertion sort
    private final int CUTOFF = 7;

    private void merge(Comparable[] src, Comparable[] dst,
                       int lo, int mid, int hi) {

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)
                dst[k] = src[j++];
            else if (j > hi)
                dst[k] = src[i++];
            else if (less(src[j], src[i]))
                dst[k] = src[j++];   // to ensure stability
            else
                dst[k] = src[i++];
        }

    }

    private void sort(Comparable[] src, Comparable[] dst,
                      int lo, int hi) {
        // if (hi <= lo) return;
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid+1, hi);

        // if (!less(src[mid+1], src[mid])) {
        //    for (int i = lo; i <= hi; i++) dst[i] = src[i];
        //    return;
        // }

        // using System.arraycopy() is a bit faster than the above loop
        if (!less(src[mid+1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }

        merge(src, dst, lo, mid, hi);
    }

    public void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length-1);
    }

    // sort from a[lo] to a[hi] using insertion sort
    private void insertionSort(Comparable[] a, int lo,
                               int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }
}
