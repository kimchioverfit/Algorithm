/**
* https://school.programmers.co.kr/learn/courses/30/lessons/17681
*/

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
        	StringBuilder sb = new StringBuilder(Integer.toBinaryString(arr1[i] | arr2[i]));
        	while (sb.length() < n) {
        		sb.insert(0, "0");
        	}
        	
        	answer[i] = sb.toString()
    					.replaceAll("1", "#")
						.replaceAll("0", " ");
        }
        return answer; 
    }
}