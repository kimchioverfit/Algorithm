/*
https://school.programmers.co.kr/learn/courses/30/lessons/258709
*/

import java.util.HashMap;

public class Solution {

    static int n = 0;
    static HashMap<String, HashMap<Integer, Integer>> map = null;
    static int maxWin = -1;
    static String maxHistory = null;

    public int[] solution(int[][] dice) {
        int[] answer = {};

        n = dice.length;
        map = new HashMap<>();
        maxWin = -1;
        maxHistory = null;

        StringBuilder sb;

        for (int i = 0; i < dice.length; i++) {
            HashMap<Integer, Integer> curMap = new HashMap<>();
            for (int value : dice[i]) {
                int cnt = curMap.getOrDefault(value, 0);
                curMap.put(value, cnt + 1);
            }
            sb = new StringBuilder();
            sb.append(i);
            map.put(sb.toString(), curMap);
        }

        StringBuilder history = new StringBuilder();
        for (int i = 0; i < n; i++) {
            history.append(i);
            dfs(i, history);
            history.deleteCharAt(0);
        }

        answer = new int[n / 2];

        for (int i = 0; i < maxHistory.length(); i++) {
            answer[i] = maxHistory.charAt(i) - '0' + 1;
        }

        return answer;
    }

    public void dfs(int cur, StringBuilder sb) {
        int length = sb.length();
        String history = sb.toString();

        if (length == n / 2) {
            StringBuilder targetSb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                // 타겟 대상 찾기
                if (!history.contains(String.valueOf(i))) {
                    targetSb.append(i);
                }
            }

            String target = targetSb.toString();
            if (!map.containsKey(target)) {
                return;
            }

            HashMap<Integer, Integer> myMap = map.get(history);
            HashMap<Integer, Integer> targetMap = map.get(target);

            int win = 0;
            int lose = 0;

            for (int mKey : myMap.keySet()) {
                int mValue = myMap.get(mKey);
                for (int tKey : targetMap.keySet()) {
                    int kValue = targetMap.get(tKey);
                    int addValue = mValue * kValue;

                    if (mKey > tKey) {
                        win += addValue;
                    }
                    else if (mKey < tKey) {
                        lose += addValue;
                    }
                }
            }

            int lastWin = win;
            String lastHistory = history;

            if (win < lose) {
                lastWin = lose;
                lastHistory = target;
            }

            if (lastWin > maxWin) {
                maxWin = lastWin;
                maxHistory = lastHistory;
            }

            return;

        }


        for (int next = cur + 1; next < n; next++) {
            sb.append(next);
            String nextHistory = sb.toString();

            if (!map.containsKey(nextHistory)) {
                HashMap<Integer, Integer> aMap = map.get(history);
                HashMap<Integer, Integer> bMap = map.get(String.valueOf(next));
                HashMap<Integer, Integer> cMap = new HashMap<>();

                for (int aKey : aMap.keySet()) {
                    int aValue = aMap.get(aKey);
                    for (int bKey : bMap.keySet()) {
                        int cKey = aKey + bKey;
                        int cValue = aValue * bMap.get(bKey);

                        int cCnt = cMap.getOrDefault(cKey, 0);
                        cMap.put(cKey, cCnt + cValue);
                    }
                }
                map.put(nextHistory, cMap);
            }
            dfs(next, sb);
            sb.deleteCharAt(length);
        }
    }


}