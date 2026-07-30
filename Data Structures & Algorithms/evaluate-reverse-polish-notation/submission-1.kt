class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        var stack = LinkedList<Int>()
        for (t in tokens) {
            if (t != "+" && t != "-" && t != "*" && t != "/") {
                stack.add(t.toInt())
            } else {
                val second = stack.removeLast()
                val first = stack.removeLast()
                if (t == "+") {
                    stack.add(first + second)
                } else if (t == "-") {
                    stack.add(first - second)
                } else if (t == "*") {
                    stack.add(first * second)
                } else {
                    stack.add(first / second)
                }
            }
        }
        return stack.first()
    }
}