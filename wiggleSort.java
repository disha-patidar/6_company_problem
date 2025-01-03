class Solution {
    public void wiggleSort(int[] nums) {
        // sort the array
          Arrays.sort(nums);
          //create an ans array
          int[] ans=new int[nums.length];
          int i=1;
          int j=nums.length-1;
          while(i<nums.length){
ans[i]=nums[j];
j--;
i=i+2;
          }
          i=0;
          while(i<nums.length){
ans[i]=nums[j];
j--;
i=i+2;
          }
          // fill the original array
          for(int k=0;k<nums.length;k++){
            nums[k]=ans[k];
          }
    }
}
