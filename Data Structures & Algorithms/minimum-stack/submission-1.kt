class MinStack() {

    var mainStack = LinkedList<Int>()
    var minStack = LinkedList<Int>()

    fun push(`val`: Int) {
        mainStack.add(`val`)
        if (minStack.count() == 0) {
            minStack.add(`val`)
        } else {
            minStack.add(minOf(`val`, minStack.last()!!))
        }
    }

    fun pop() {
        mainStack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return mainStack.last()!!
    }

    fun getMin(): Int {
        return minStack.last()!!
    }
}
