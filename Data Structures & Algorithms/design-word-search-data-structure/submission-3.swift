class WordDictionary {

    class Node {
        var children = [Character: Node]()
        var end = false
    }

    var root = Node()

    func addWord(_ word: String) {
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

    func search(_ word: String) -> Bool {

        let arr = Array(word)

        func search(_ index: Int, _ node: Node) -> Bool {

            if index == arr.count {
                return node.end
            }

            let currentCh = arr[index]

            if currentCh == "." {

                for (nextCh, nextNode) in node.children {
                    if search(index + 1, nextNode) {
                        return true
                    }
                }

                return false

            } else {
                if node.children[currentCh] == nil {
                    return false
                }
                return search(index + 1, node.children[currentCh]!)
            }
        }

        return search(0, root)

    }
}
