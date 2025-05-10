/* https://school.programmers.co.kr/learn/courses/30/lessons/150367 */

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];       
        
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            if (number == 0) {
                answer[i] = 0;
            }
            else if (number == 1) {
                answer[i] = 1;
            }
            else {
                String bin = getBinary(number);
                boolean ret = getMid(bin, 0, bin.length() - 1);
                answer[i] = ret ? 1 : 0;                
            }
        }
        
        return answer;
    }
    
    private boolean getMid(String bin, int start, int end) {
        int mid = (start + end) / 2;
        
        if (bin.charAt(mid) == '1') {
            if (start + 2 == end) {
                return true;
            }
            return getMid(bin, start, mid - 1) && getMid(bin, mid + 1, end);
        }
        else {
        	int index = bin.indexOf('1', start);
    		if (index != -1 && index <= end) {
    			return false;
    		}
    		return true;
        } 
    }
    
    private String getBinary(long number) {
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            sb.append(String.valueOf(number % 2));
            number /= 2;
        }
        
        int length = sb.length();
        
        int cnt = 0;
        int targetLength = 1;
        
        while (length != 0) {
            length /= 2;
            targetLength *= 2;
        }
        
        while (targetLength - 1 > sb.length()) {
            sb.append("0");
        }
                
        return sb.reverse().toString();
    }
}