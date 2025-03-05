/** https://leetcode.com/problems/implement-trie-prefix-tree/
 */
class Trie {
    HashMap<Character, HashMap> root = null;

    public Trie() {
        root = new HashMap<Character, HashMap>();
    }
    
    public void insert(String word) {
        char[] charArr = word.toCharArray();
        HashMap<Character, HashMap> map = root;

        for (char c : charArr) {
            if (map.containsKey(c)) {
                map = map.get(c);
            }
            else {
                map.put(c, new HashMap<Character, HashMap>());
                map = map.get(c);
            }
        }
        map.put('.', null);
    }
    
    public boolean search(String word) {
        char[] charArr = word.toCharArray();
        HashMap<Character, HashMap> map = root;
        
        for (char c : charArr) {
            if (map.containsKey(c)) {
                map = map.get(c);
            }
            else {
                return false;
            }
        }
        return map.containsKey('.');
    }
    
    public boolean startsWith(String prefix) {
        char[] charArr = prefix.toCharArray();
        HashMap<Character, HashMap> map = root;
        
        for (char c : charArr) {
            if (map.containsKey(c)) {
                map = map.get(c);
            }
            else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */