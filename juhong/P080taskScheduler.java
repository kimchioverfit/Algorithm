/** https://leetcode.com/problems/task-scheduler/
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {        

        int[] cnt = new int[26];
        int[] lastVisited = new int[26];
        Arrays.fill(lastVisited, -1);

        for (char task : tasks) {
            cnt[task - 'A'] += 1;
        }

        int curIndex = 0;

        while (true) {
            boolean left = false;
            int jumpIndex = curIndex + n;
            int maxCnt = -1;
            int maxIndex = -1;

            for (int i = 0; i < 26; i++) {
                int nextVisited = lastVisited[i] + n;
                if ( cnt[i] > 0 ) {
                    left = true;
                    if (lastVisited[i] == -1 || nextVisited < curIndex) {
                        if (maxCnt < cnt[i]) {
                            maxCnt = cnt[i];
                            maxIndex = i;
                        }
                    }
                    else {
                        jumpIndex = jumpIndex < nextVisited ? jumpIndex : nextVisited;
                    }
                }
            }

            if (!left) break;

            if (maxIndex == -1) {
                if (curIndex >= jumpIndex) {
                    curIndex += 1;
                }
                else {
                    curIndex = jumpIndex;

                }
            }
            else {
                cnt[maxIndex] -= 1;
                lastVisited[maxIndex] = curIndex;
                curIndex += 1;
            }

        }

        return curIndex;
    }
}