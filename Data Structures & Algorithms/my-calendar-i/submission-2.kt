class MyCalendar() {

    class Node(
        val startTime: Int,
        val endTime: Int
    ) {
        var left: Node? = null
        var right: Node? = null
    }

    var root: Node? = null

    fun addNode(node: Node, startTime: Int, endTime: Int): Boolean {
        if (startTime >= node.endTime) {
            if (node.right == null) {
                node.right = Node(startTime, endTime)
                return true
            }
            return addNode(node.right!!, startTime, endTime)
        } else if (endTime <= node.startTime) {
            if (node.left == null) {
                node.left = Node(startTime, endTime)
                return true
            }
            return addNode(node.left!!, startTime, endTime)
        }
        return false
    }

    fun book(startTime: Int, endTime: Int): Boolean {
        if (root == null) {
            root = Node(startTime, endTime)
            return true
        }

        return addNode(root!!, startTime, endTime)
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(startTime,endTime)
 */