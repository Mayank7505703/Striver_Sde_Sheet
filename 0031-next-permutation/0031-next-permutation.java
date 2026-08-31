class Solution {
    public void reverse(int start , int end , int nums[]){
        while(start<end){
            int temp =nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int idx=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            reverse(0 , nums.length-1, nums);
            return;
        }

        for(int i =nums.length-1;i>=0;i--){
            if(nums[i]>nums[idx]){
                int temp =nums[idx];
                nums[idx]=nums[i];
                nums[i]=temp;
                break;
            }
        }
        reverse(idx+1 , nums.length-1, nums);

    }
}