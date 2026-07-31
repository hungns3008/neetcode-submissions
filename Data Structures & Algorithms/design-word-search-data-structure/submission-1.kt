class WordDictionary {

    class Node {
        var children = HashMap<Char, Node>()
        var end = false
    }

    var root = Node()

    fun addWord(word: String) {
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

        fun search(node: Node, i: Int): Boolean {
            if (i == word.count()) {
                return node.end
            }
            var ch = word[i]
            if (ch == '.') {
                for ((ch, children) in node.children) {
                    if (search(children, i + 1)) {
                        return true
                    }
                }
                return false
            } else {
                if (node.children[ch] == null) {
                    return false
                }
                return search(node.children[ch]!!, i + 1)
            }
        }
        
        return search(root, 0)

    }
}
