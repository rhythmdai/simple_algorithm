package leetcode;

import java.util.List;
import java.util.Map;

public class S4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // to ensure m<=n
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int l = 0;
        int r = m;
        int i = 0, j = 0;
        int indexSum = (m + n + 1) / 2;
        //nums1[i - 1] <= nums2[j] && nums1[j-1] <= nums2[i]
        // 2* (i + j) = m+n
        while (l < r) {
            i = (l + r) / 2;
            j = indexSum - i;
            if (i < r && nums2[j - 1] > nums1[i]) {
                l = i + 1;
            } else if (i > l && nums1[i - 1] > nums2[j]) {
                r = i - 1;
            } else {
                break;
            }
        }
        if(((m+n)&1) == 0){
            if(i==m){
                return (nums1[m-1]+nums2[j])*0.1/2;
            }else if(i==0){
                return (nums1[0]+nums2[n-1])*0.1/2;
            }else {
               int sum =  Math.max(nums1[i-1],nums2[j-1])+Math.min(nums1[i],nums2[j]);
               return sum*1.0/2;
            }
        }else {
            if(i==m){

            }
        }
        if(i==m){

        }
        return 0;
    }

    public static void main(String[] args) {
        int size = 10;

        int[] nums1 = new int[size];
        int[] nums2 = new int[size];
    //    new S4().findMedianSortedArrays(nums1, nums2);
        for (int i = 1; i <= size; i++) {
            nums1[i - 1] = i;
        }
        System.out.println(bSearch(nums1,100));
    }

    public static int bSearch(int[] a , int t){
/*        if(t<a[0]){
            return -1;
        }else if(t>a[a.length-1]){
            return a.length;
        }*/
        int l = 0;
        int r = a.length-1;
        int mid = 0;
        while (l<=r){
            mid = (l+r)/2;
            if(a[mid]==t){
                return mid;
            }else if(a[mid]>t){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return l;
    }
}
