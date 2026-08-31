class Solution {
    public void sortColors(int[] nums) {
        int z=0;
        int o=0;
        int t=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                z++;
            }
            else if(nums[i]==1){
                o++;
            }
            else{
                t++;
            }
        }
        int k=0;
        while(k<z){
            nums[k++]=0;
        }
        while(k<z+o){
            nums[k++]=1;
        }
        while(k<z+o+t){
            nums[k++]=2;
        }
    }
}