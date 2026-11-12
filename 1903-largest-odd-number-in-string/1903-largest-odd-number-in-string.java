
class Solution {
    public String largestOddNumber(String num) {

        String ans = "";
        int count = 0;

        for (int i = num.length() - 1; i >= 0; i--) {
            int r = num.charAt(i) - '0';

            if (r % 2 != 0) {
                count = i + 1;
                break;
            }
        }

        if (count == 0) {
            return "";
        }

        ans = num.substring(0, count);

        return ans;
    }
}
