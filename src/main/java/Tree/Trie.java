package Tree;

/**
 * @program: leetcode
 * @description: 208
 * @author: Skyler
 * @create: 2024-03-31 15:24
 **/

public class Trie {
    boolean isEnd;
    Trie[] children = new Trie[26];
    public Trie() {
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        isEnd = false;
    }

    public void insert(String word) {
        Trie now = this;
        for (int i = 0; i < word.length(); i++) {
            if (now.children[word.charAt(i) - 'a'] == null){
                now.children[word.charAt(i) - 'a'] = new Trie();
            }
            now = now.children[word.charAt(i) - 'a'];
        }
        now.isEnd = true;
    }

    public boolean search(String word) {
        Trie find = this;
        for (int i = 0; i < word.length(); i++) {
            if (find.children[word.charAt(i) - 'a'] == null)
                return false;
            find = find.children[word.charAt(i) - 'a'];
        }
        return find.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie find = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (find.children[prefix.charAt(i) - 'a'] == null)
                return false;
            find = find.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

