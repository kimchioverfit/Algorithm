/** https://leetcode.com/problems/palindrome-pairs/
 */

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            trie.insert(word, i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            ArrayList<Integer> searchedList = trie.search(word);
            for (int searched : searchedList) {
                if (searched != i) {
                    ArrayList<Integer> element = new ArrayList<>();
                    element.add(i);
                    element.add(searched);
                    result.add(element);
                }
            }

        }
        return result;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    private boolean isPalindrome(String word, int start, int end) {
        StringBuilder sb = new StringBuilder(word);
        String substr = sb.substring(start, end);
        if (substr.equals(new StringBuilder(substr).reverse().toString())) {
            return true;
        }
        return false;
    }

    public void insert(String word, int wordIndex) {
        Node node = root;
        String reversedWord = new StringBuilder(word).reverse().toString();

        for (int i = 0; i < reversedWord.length(); i++) {
            if (isPalindrome(word, 0, word.length() - i)) {
                if (node.palindromeList == null) {
                    node.palindromeList = new ArrayList<>();
                }
                node.palindromeList.add(wordIndex);
            }
            int ch = reversedWord.charAt(i) - 'a';
            if (node.nodes[ch] == null) {
                node.nodes[ch] = new Node();
            }
            node = node.nodes[ch];
        }
        node.wordIndex = wordIndex;
    }
    
    public ArrayList<Integer> search(String word) {
        ArrayList<Integer> result = new ArrayList<>();
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node.wordIndex != -1 && isPalindrome(word, i, word.length())) {
                result.add(node.wordIndex);
            }
            Node next = node.nodes[word.charAt(i) - 'a'];
            if (next == null) return result;
            node = next;
        }
        if (node.palindromeList != null) {
            result.addAll(node.palindromeList);
        }
        if (node.wordIndex != -1) {
            result.add(node.wordIndex);
        }
        return result;
    }
}

class Node {
    Node[] nodes;
    int wordIndex = -1;
    ArrayList<Integer> palindromeList = null;

    Node() {
        nodes = new Node[26];
    }
}