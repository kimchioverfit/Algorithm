/*
https://school.programmers.co.kr/learn/courses/30/lessons/258705
*/

class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;

        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        a[1] = 1;

        if (tops[0] == 0) {
            b[1] = 2;
        }
        else {
            b[1] = 3;
        }

        for (int k = 2; k <= n; k++) {
            a[k] = (a[k - 1] + b[k - 1]) % 10007;
            if (tops[k - 1] == 0) {
                b[k] = (a[k - 1] + 2 * b[k - 1]) % 10007;
            }
            else {
                b[k] = (2 * a[k - 1] + 3 * b[k - 1]) % 10007;
            }
        }

        answer = (a[n] + b[n]) % 10007;
        return answer;
    }
}