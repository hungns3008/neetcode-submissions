class Solution {

    class Node {
        var children = [Character: Node]()
        var end = false
    }

    var root = Node()

    func insert(_ word: String) {
        var current = root
        let arr = Array(word)
        for i in 0 ..< arr.count {
            let ch = arr[i]
            if current.children[ch] == nil {
                current.children[ch] = Node()
            }
            current = current.children[ch]!
        }
        current.end = true
    }

    func findWords(_ board: [[Character]], _ words: [String]) -> [String] {

        for word in words {
            insert(word)
        }

        var output = [String]()

        var path = Set<String>()

        func dfs(_ r: Int, _ c: Int, _ node: Node, _ current: String) {
            if r >= 0 && r < board.count && c >= 0 && c < board[0].count && !path.contains("\(r)-\(c)") {
                let currentCh = board[r][c]
                if let currentNode = node.children[currentCh] {
                    let new = "\(current)\(board[r][c])"
                    if currentNode.end {
                        output.append(new)
                        currentNode.end = false
                    }
                    path.insert("\(r)-\(c)")

                    dfs(r + 1, c, currentNode, new)
                    dfs(r - 1, c, currentNode, new)
                    dfs(r, c + 1, currentNode, new)
                    dfs(r, c - 1, currentNode, new)

                    path.remove("\(r)-\(c)")
                }
            }
        }

        for r in 0 ..< board.count {
            for c in 0 ..< board[0].count {
                dfs(r, c, root, "")
            }
        }

        return output

    }
}
