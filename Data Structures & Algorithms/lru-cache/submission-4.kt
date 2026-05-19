class LRUCache(capacity: Int) {

    class Node() {
        var key: Int = -1
        var value: Int = -1
        var next: Node? = null
        var prev: Node? = null
    }

    var hash = HashMap<Int, Node>()

    var start = Node()
    var end = Node()

    var size = 0
    var currentSize = 0

    init {
        size = capacity
        start.next = end
        end.prev = start
    }

    fun get(key: Int): Int {
        if (hash[key] == null) {
            return -1
        }

        var node = hash[key]!!

        insertNode(node)

        printState()

        return node.value

    }

    fun put(key: Int, value: Int) {
        if (hash[key] == null) {
            if (currentSize == size) {
                removeNode()
            }
            var newNode = Node()
            newNode.key = key
            newNode.value = value
            insertNode(newNode)
            currentSize += 1
        } else {
            var existingNode = hash[key]!!
            existingNode.value = value
            insertNode(existingNode)
        }
        printState()
    }

    fun insertNode(node: Node) {
        
        hash[node.key] = node

        var prev = node.prev
        var next = node.next

        prev?.next = next
        next?.prev = prev

        var newPrev = end.prev
        
        node.next = end
        node.prev = newPrev

        newPrev?.next = node
        end.prev = node
    }

    fun removeNode() {
        var removedNode = start.next
        var next = removedNode?.next

        start.next = next
        next?.prev = start

        removedNode?.key?.let {
            hash.remove(it)
        }

        currentSize -= 1
    }

    fun printState() {
        var current = start.next
        print("Size: ${currentSize} Start -> ")
        while (current != end) {
            if (current?.next == end) {
                print("[${current?.key}: ${current?.value}] ")
            } else {
                print("[${current?.key}: ${current?.value}] -> ")
            }
            current = current?.next
        }
        print("End\n")
    }
}
