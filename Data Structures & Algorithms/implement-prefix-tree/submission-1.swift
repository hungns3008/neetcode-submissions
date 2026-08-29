class PrefixTree {

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

    func search(_ word: String) -> Bool {
        var current = root
        let arr = Array(word)
        for i in 0 ..< arr.count {
            let ch = arr[i]
            if current.children[ch] == nil {
                return false
            }
            current = current.children[ch]!
        }
        return current.end
    }

    func startsWith(_ prefix: String) -> Bool {
        var current = root
        let arr = Array(prefix)
        for i in 0 ..< arr.count {
            let ch = arr[i]
            if current.children[ch] == nil {
                return false
            }
            current = current.children[ch]!
        }
        return true
    }
}
