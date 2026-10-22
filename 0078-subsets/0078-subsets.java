class Solution {
    public void fun(int nums[] , List<List<Integer>>ans , List<Integer>list,int idx){
        if(idx==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        fun(nums, ans , list , idx+1);
        list.remove(list.size()-1);
        fun(nums, ans , list , idx+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        fun(nums ,ans , list, 0);
        return ans;
    }
}