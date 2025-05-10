/* https://school.programmers.co.kr/learn/courses/30/lessons/150366 */
import java.util.*;

class Solution {
    String[] arr = new String[5051];
    int[] root = new int[5051];
    int[] rank = new int[5051];
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

    public int getIndex(int i, int j) {
        return i * 100 + j;
    }

    public void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x == y)  return;
        if (rank[x] < rank[y]) {
            root[x] = y;
        }
        else {
            root[y] = x;
            if (rank[x] == rank[y]) rank[x]++;
        }
    }

    /* find(x): 재귀 이용 */
    public int find(int x) {
        if (root[x] == x) {
            return x;
        }
        else {
            return root[x] = find(root[x]);
        }
    }

    public String[] solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();
        int index = -1;
        int rootIndex = -1;
        int key = -1;
        HashSet<Integer> set = null;
        String value = null;

        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                index = getIndex(i, j);
                root[index] = index;
                rank[index] = 0;
            }
        }

        for (String command : commands) {
            String[] commandArr = command.split(" ");

            switch (commandArr[0]) {
                case "UPDATE" :
                    if (commandArr.length == 4) {
                        index = getIndex(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]));
                        rootIndex = find(index);
                        value = commandArr[3];
                        
                        arr[rootIndex] = value;
                        
                        set = map.getOrDefault(rootIndex, new HashSet<>());
                        set.add(index);
                        map.put(rootIndex, set);
                    }
                    else {
                    	for (int i : map.keySet()) {
                    		if (commandArr[1].equals(arr[i])) {
                    			arr[i] = commandArr[2];
                    		}
                    	}
                    }
                    break;
                    
                case "MERGE" :
                    int index1 = getIndex(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]));
                    int index2 = getIndex(Integer.parseInt(commandArr[3]), Integer.parseInt(commandArr[4]));
                    int rootIndex1 = find(index1);
                    int rootIndex2 = find(index2);

                    value = arr[rootIndex1];
                    if (value == null) {
                    	value = arr[rootIndex2];
                    }
                    arr[rootIndex1] = null;
                    arr[rootIndex2] = null;

                    set = new HashSet<Integer>();
                    HashSet<Integer> set1 = map.get(rootIndex1);
                    HashSet<Integer> set2 = map.get(rootIndex2);
                    
                    if (set1 == null) {
                    	set1 = new HashSet<>();
                    	set1.add(rootIndex1);
                    }
                    if (set2 == null) {
                    	set2 = new HashSet<>();
                    	set2.add(rootIndex2);
                    }
                    
                	set.addAll(set1);
                	set.addAll(set2);

                    map.remove(rootIndex1);
                    map.remove(rootIndex2);
                    
                    union(rootIndex1, rootIndex2);                    
                    key = find(rootIndex1);                    
                    map.put(key, set);
                    arr[key] = value;

                    break;

                case "UNMERGE" :
                    index = getIndex(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]));
                    // MAP 사용하기
                    rootIndex = find(index);
                    value = arr[rootIndex];
                    
                    set = map.get(rootIndex);
                    if (set != null) {
                        for (int leaf : set) {
                        	root[leaf] = leaf;
                        	rank[leaf] = leaf;
                        	arr[leaf] = null;
                        }
                    }
                    map.remove(rootIndex);
                    arr[index] = value;
                    break;

                default :
                    index = getIndex(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]));
                    value = arr[find(index)];
                    answer.add(value == null ? "EMPTY" : value);
                    break;
            }

            // System.out.println(command + " ");
            // System.out.println(map);
        }

        return answer.toArray(new String[0]);
    }
}