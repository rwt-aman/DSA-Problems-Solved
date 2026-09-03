class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] temp = new int[size];
        int k = 0;
        int i=0,j=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                temp[k++] = nums1[i++];
            }
            else{
                temp[k++] = nums2[j++];
            }
        }
        while(i<nums1.length){
            temp[k++] = nums1[i++];
        }
        while(j<nums2.length){
            temp[k++] = nums2[j++];
        }
        int mid = temp.length/2;

        if(temp.length % 2 == 0){
            return (temp[mid-1] + temp[mid]) / 2.0;            
        }
        else{
            return temp[mid];
        }
    }
}