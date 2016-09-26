public class Solution {
    /**
    * comparition starts from tail while(n1 >= 0 && n2 >= 0)
    * make sure nums2 is finished while(n2 >= 0)
    **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
      if (nums1 == null || nums2 == null || m > nums1.length || n > nums2.length) {
            return;
      }
      int n1 = m-1, n2 = n-1, index = m+n-1;
      
      while(n1 >= 0 && n2 >= 0){
          if(nums1[n1] > nums2[n2]){
              nums1[index--] = nums1[n1--];
          }else{
              nums1[index--] = nums2[n2--];
          }
      }
      while(n2 >= 0){
          nums1[index--] = nums2[n2--];
      }
        
    }
}
