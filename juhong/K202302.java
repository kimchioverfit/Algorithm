/* https://school.programmers.co.kr/learn/courses/30/lessons/150369 */

import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> deliveryStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
        	if (deliveries[i] != 0) {
        		deliveryStack.push(i);
        	}
        	if (pickups[i] != 0) {
        		pickupStack.push(i);
        	}
        }
        
        while (true) {
        	int deliveryCap = cap;
        	int pickupCap = cap;

            int deliveryMaxIndex = -1;
            int pickupMaxIndex = -1;
            int index = -1;
            
            while (deliveryStack.size() > 0 && deliveryCap != 0) {
            	index = deliveryStack.pop();
            	
        		if (deliveryMaxIndex == -1) {
        			deliveryMaxIndex = index;
        		}
        		
        		if (deliveries[index] > deliveryCap) {
        			deliveries[index] -= deliveryCap;
        			deliveryCap = 0;
        			deliveryStack.push(index);
        		}
        		else {
        			deliveryCap -= deliveries[index];
        			deliveries[index] = 0;
        		}
        	}
            
            
            while (pickupStack.size() > 0 && pickupCap != 0) {
            	index = pickupStack.pop();
            	
        		if (pickupMaxIndex == -1) {
        			pickupMaxIndex = index;
        		}
        		
        		if (pickups[index] > pickupCap) {
        			pickups[index] -= pickupCap;
        			pickupCap = 0;
        			pickupStack.push(index);
        		}
        		else {
        			pickupCap -= pickups[index];
        			pickups[index] = 0;
        		}
        	}
                        
            if (deliveryMaxIndex == -1 && pickupMaxIndex == -1) {
            	break;
            }
            answer += (((deliveryMaxIndex > pickupMaxIndex ? deliveryMaxIndex : pickupMaxIndex) + 1) * 2);
        }
        return answer;
    }
}