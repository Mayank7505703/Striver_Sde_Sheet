class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set=new HashSet<>();
        int i =0;
        int j=0;
        int len =0;
        int max=0;
        while(j<s.length()){
           
            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            len=j-i+1;
            max=Math.max(max,len);
            set.add(s.charAt(j));
            j++;        
            }
        return max;
    }
}