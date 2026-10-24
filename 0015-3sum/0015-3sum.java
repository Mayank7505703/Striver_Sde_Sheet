
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            HashSet<Integer> set1 = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int target = -(nums[i] + nums[j]);

                if (set1.contains(target)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(target);

                    Collections.sort(triplet);

                    if (set.add(triplet)) {
                        list.add(triplet);
                    }
                }

                set1.add(nums[j]);
            }
        }

        return list;
    }
}
