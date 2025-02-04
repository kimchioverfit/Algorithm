/**
 * https://leetcode.com/problems/daily-temperatures/submissions/1525511957/
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Tuple> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];

            while (!stack.isEmpty() && stack.peek().getValue() < temperature) {
                int index = stack.pop().getIndex();
                result[index] = i - index;
            }

            stack.push(new Tuple(temperature, i));
        }

        return result;
    }

    private class Tuple {
        private int value;
        private int index;

        private Tuple(int value, int index) {
            this.value = value;
            this.index = index;
        }

        private int getValue() {
            return value;
        }

        private int getIndex() {
            return index;
        }
    }
}