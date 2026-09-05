class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        for(int i =0;i<nums.length;i++){
            if(i>max){
                return false;
            }
            int total = nums[i]+i;
            max=Math.max(max,total);
        }
        return true;
    }
}