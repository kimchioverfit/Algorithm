/*
https://school.programmers.co.kr/learn/courses/30/lessons/258711
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {

    HashMap<Integer, ArrayList<Integer>> map = null;
    int donut = 0;
    int line = 0;
    int eight = 0;

    public int[] solution(int[][] edges) {

        donut = 0;
        line = 0;
        eight = 0;
        map = new HashMap<>();

        HashSet<Integer> startSet = new HashSet<>();
        HashSet<Integer> endSet = new HashSet<>();
        for (int[] edge : edges) {
            ArrayList<Integer> arr = map.getOrDefault(edge[0], new ArrayList<>());
            arr.add(edge[1]);
            map.put(edge[0], arr);
            startSet.add(edge[0]);
            endSet.add(edge[1]);
        }
        startSet.removeAll(endSet);

        int key = -1;
        int max = -1;
        for (int i : startSet) {
            int size = map.get(i).size();
            if (max < size) {
                max = size;
                key = i;
            }
        }

        ArrayList<Integer> nextArr = map.get(key);
        for (int next : nextArr) {
            define(next, next, true);
        }

        return new int[] {key, donut, line, eight};
    }

    public void define(int start, int cur, boolean isFirst) {
        ArrayList<Integer> nextArr =  map.get(cur);

        if (nextArr == null) {
            line += 1;
            return;
        }

        if (nextArr.size() == 2) {
            eight += 1;
            return;
        }

        if (!isFirst && start == cur) {
            donut += 1;
            return;
        }

        for (int next : nextArr) {
            define(start, next, false);
        }
    }
}

