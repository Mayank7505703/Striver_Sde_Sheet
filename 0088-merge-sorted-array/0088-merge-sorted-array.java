class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int c[]=new int[m+n];
        int i =0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                c[k++]=nums1[i++];
            }
            else{
                c[k++]=nums2[j++];
            }
        }
        while(i<m){
            c[k++]=nums1[i++];
        }
        while(j<n){
            c[k++]=nums2[j++];
        }
        int t=0;
        for(int g : c){
            nums1[t++]=g;
        }
    }
}