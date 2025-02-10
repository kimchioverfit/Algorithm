class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, SortedSet<String>> map = new HashMap<>();

        HashMap<String, Integer> city = new HashMap<>();
        int cityId = 0;
        int[][] visit = new int[301][301];

        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String end = ticket.get(1);

            SortedSet<String> arrival = null;
            if (map.containsKey(start)) {
                arrival = map.get(start);
            }
            else {
                arrival = new TreeSet<String>();
            }
            arrival.add(end);
            map.put(start, arrival);

            if (!city.containsKey(start)) {
                city.put(start, cityId++);
            }
            if (!city.containsKey(end)) {
                city.put(end, cityId++);
            }
            visit[city.get(start)][city.get(end)] += 1;
        }

        String[] route = new String[tickets.size() + 1];
        route[0] = "JFK";

        return perm("JFK", visit, city, map, route, tickets.size() + 1, 1);
    }
    public ArrayList<String> perm(String destination, int[][] visit, HashMap<String, Integer> city, HashMap<String, SortedSet<String>> map, String[] route, int size, int index) {
        ArrayList<String> result = null;
        if (index == size) {
            result = new ArrayList<>(Arrays.asList(route));
            return result;
        }

        SortedSet<String> destArr = map.get(destination);
        if (destArr != null) {
            for (String next : destArr) {

                int start = city.get(destination);
                int end = city.get(next);

                if (visit[start][end] != 0) {
                    visit[start][end] -= 1;
                    route[index] = next;
                    result = perm(next, visit, city, map, route, size, index + 1);
                    if (result != null) {
                        break;
                    }
                    visit[start][end] += 1;
                }
            }
        }
        return result;
    }
}