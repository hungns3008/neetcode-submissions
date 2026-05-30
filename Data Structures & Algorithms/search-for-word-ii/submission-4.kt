class Solution {

    class Node {
        var children = HashMap<Char, Node>()
        var end = false
    }

    var root = Node()

    fun insertWord(word: String) {
        var current = root
        for (ch in word) {
            if (current.children[ch] == null) {
                current.children[ch] = Node()
            }
            current = current.children[ch]!!
        }
        current.end = true
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {

        root = Node()

        for (word in words) {
            insertWord(word)
        }

        var output = mutableListOf<String>()
        val path = mutableSetOf<String>()

        fun search(i: Int, j: Int, node: Node, currentString: String) {

            if (i < 0 || i >= board.count() || 
            j < 0 || j >= board[0].count() || path.contains("${i}-${j}") || node.children[board[i][j]] == null) {
                return
            }
            
            path.add("${i}-${j}")
            val ch = board[i][j]
            val newNode = node.children[ch]!!
            val newString = currentString + ch
            if (newNode.end) {
                output.add(newString)
                newNode.end = false
            }

            search(i, j + 1, newNode, newString)
            search(i + 1, j, newNode, newString)
            search(i, j - 1, newNode, newString)
            search(i - 1, j, newNode, newString)

            path.remove("${i}-${j}")

        }

        for (i in 0 ..< board.count()) {
            for (j in 0 ..< board[0].count()) {
                search(i, j, root, "")
            }
        }

        return output

    }
}
