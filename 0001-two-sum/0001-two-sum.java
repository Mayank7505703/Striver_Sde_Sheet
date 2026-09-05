class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int c[]={-1,-1};
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                c[0]=map.get(target-nums[i]);
                c[1]=i;
            }
            map.putIfAbsent(nums[i],i);
        }
        return c;
    }
}