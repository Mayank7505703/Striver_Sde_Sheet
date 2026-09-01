class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>map =new HashMap<>();
        for(int i :nums){
            map.put(i ,map.getOrDefault(i,0)+1);
        }
        for(int k : map.keySet()){
            if(map.get(k)>nums.length/2){
                return k;
            }
        }
        return -1;
    }
}