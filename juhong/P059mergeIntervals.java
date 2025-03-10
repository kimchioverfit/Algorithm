/** https://leetcode.com/problems/merge-intervals/
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int lastLeft = -1;
        int lastRight = -1;
        for (int[] cur : intervals) {
            // 
            if (lastRight < cur[0] && lastLeft != -1) {
                ArrayList<Integer> element = new ArrayList<>();
                element.add(lastLeft);
                element.add(lastRight);
                result.add(element);

                lastLeft = -1;
                lastRight = -1;
            }
            else {
                lastRight = lastRight < cur[1] ? cur[1] : lastRight;
            }

            if (lastLeft == -1) {
                lastLeft = cur[0];
                lastRight = cur[1];
            }
        }

        if (lastLeft != -1) {
            ArrayList<Integer> element = new ArrayList<>();
            element.add(lastLeft);
            element.add(lastRight);
            result.add(element);
        }

        int[][] arr = new int[result.size()][2];

        int index = 0;
        for (ArrayList<Integer> element : result) {
            arr[index][0] = element.get(0);
            arr[index][1] = element.get(1);
            index += 1;
        }

        return arr;
    }
}