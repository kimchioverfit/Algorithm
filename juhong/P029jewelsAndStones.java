/**
 * https://leetcode.com/problems/jewels-and-stones/submissions/1528761986/
 */

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        HashMap<Character, Integer> stoneMap = new HashMap<>();

        for (int i = 0; i < stones.length(); i++) {
            char stone = stones.charAt(i);

            int stoneCnt = 0;
            if (stoneMap.containsKey(stone)) {
                stoneCnt = stoneMap.get(stone);
            }
            stoneMap.put(stone, stoneCnt + 1);
        }

        for (char jewel : jewels.toCharArray()) {
            if (stoneMap.containsKey(jewel)) {
                result += stoneMap.get(jewel);
            }
        }

        return result;
    }
}