/** https://leetcode.com/problems/intersection-of-two-arrays/
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] result = null;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);

        result = new int[set1.size()];
        int idx = 0;
        for (int num : set1) {
            result[idx++] = num;
        }
        
        return result;
    }
}