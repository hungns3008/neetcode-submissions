class LRUCache {

    class Node {
        var key: Int
        var value: Int
        var next: Node? = nil
        var prev: Node? = nil

        init(_ key: Int, _ value: Int) {
            self.key = key
            self.value = value
        }
    }

    var hash = [Int: Node]()
    var head = Node(-1, -1)
    var tail = Node(-1, -1)
    var size = 0
    var cap = 0

    init(_ capacity: Int) {
        cap = capacity
        head.next = tail
        tail.prev = head
    }

    func addLast(_ node: Node) {
        let prev = tail.prev
        node.next = tail
        node.prev = prev
        prev?.next = node
        tail.prev = node
    }

    func removeNode(_ node: Node) {
        let prev = node.prev
        let next = node.next

        prev?.next = next
        next?.prev = prev
    }

    func get(_ key: Int) -> Int {
        let node = hash[key]
        if node == nil {
            return -1
        }
        removeNode(node!)
        addLast(node!)
        return node!.value
    }

    func put(_ key: Int, _ value: Int) {
        let node = hash[key]
        if node == nil {
            if size == cap {
                let first = head.next!
                hash.removeValue(forKey: first.key)
                removeNode(first)
            } else {
                size += 1
            }
            let newNode = Node(key, value)
            hash[key] = newNode
            addLast(newNode)
        } else {
            node!.value = value
            removeNode(node!)
            addLast(node!)
        }
    }
}