/** https://leetcode.com/problems/top-k-frequent-elements/
 */
import java.util.*;

class Tuple implements Comparable<Tuple> {
    int cnt;
    int num;

    public Tuple(int cnt, int num) {
        this.cnt = cnt;
        this.num = num;
    }

    @Override
    public int compareTo(Tuple o) {
        return o.cnt - this.cnt;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }

        int cnt = 1;
        int[] result = new int[k];
        ArrayList<Tuple> list = new ArrayList<>();

        Arrays.sort(nums);
        
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i - 1] != nums[i]) {
                list.add(new Tuple(cnt, nums[i - 1]));
                cnt = 1;
            }
            else {
                cnt += 1;
            }
        }

        Collections.sort(list);
        
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).num;
        }

        return result;
    }
}