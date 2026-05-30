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

        fun search(startIndex: Int, node: Node): Boolean {
            var current = node
            for (i in startIndex ..< word.count()) {
                var ch = word[i]
                if (ch == '.') {
                    for ((_, childNode) in current.children) {
                        if (search(i + 1, childNode)) {
                            return true
                        }
                    }
                    return false
                } else {
                    if (current.children[ch] != null) {
                        current = current.children[ch]!!
                    } else {
                        return false
                    }
                }
            }
            return current.end
        }

        return search(0, root)

    }
}
