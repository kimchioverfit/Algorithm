/** https://leetcode.com/problems/largest-number/
 */

class Solution {
    public String largestNumber(int[] nums) {
        String[] strNumArr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strNumArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNumArr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s2.compareTo(s1);
                }
                else {
                    StringBuilder s1b = new StringBuilder(s1);
                    StringBuilder s2b = new StringBuilder(s2);
                    
                    s1b.append(s2);
                    s2b.append(s1);

                    return s2b.compareTo(s1b);
                }
            }
        });

        StringBuilder sb = new StringBuilder("");
        for (String strNum : strNumArr) {
            sb.append(strNum);
        }

        return allZeroException(sb.toString());
    }

    private String allZeroException(String result) {
        for (char c : result.toCharArray()) {
            if (c != '0') {
                return result;
            }
        }
        return "0";
    }
}