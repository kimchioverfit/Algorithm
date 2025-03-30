/** https://leetcode.com/problems/queue-reconstruction-by-height/
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][2];
        boolean[] choosed = new boolean[people.length];

        Arrays.sort(people, (o1, o2) -> ( o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0] ));
        
        for (int[] person : people) {
            int value = person[0];
            int position = person[1];
            int cnt = 0;

            for (int i = 0; i < people.length; i++) {
                if (!choosed[i]) {
                    if (cnt == position) {
                        choosed[i] = true;
                        result[i] = person;
                        break;
                    }
                    cnt += 1;
                }
            }
        }

        return result;
    }
}