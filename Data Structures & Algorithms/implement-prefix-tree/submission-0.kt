class PrefixTree {

    class Node() {
        var children = HashMap<Char, Node>()
        var end = false
    }

    var root = Node()

    fun insert(word: String) {
        var current = root
        for (ch in word) {
            if (current.children[ch] == null) {
                current.children[ch] = Node()
            }
            current = current.children[ch]!!
        }
        current.end = true
    }

    fun search(word: String): Boolean {
        var current = root
        for (ch in word) {
            if (current.children[ch] == null) {
                return false
            }
            current = current.children[ch]!!
        }
        return current.end
    }

    fun startsWith(prefix: String): Boolean {
        var current = root
        for (ch in prefix) {
            if (current.children[ch] == null) {
                return false
            }
            current = current.children[ch]!!
        }
        return true
    }
}
