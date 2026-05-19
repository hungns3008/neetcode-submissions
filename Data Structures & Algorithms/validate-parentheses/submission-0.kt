class Solution {
    fun isValid(s: String): Boolean {

        var stack = LinkedList<Char>()

        for (i in 0 ..< s.count()) {
            if (s[i] == '{' || s[i] == '[' || s[i] == '(') {
                stack.add(s[i])
            } else {
                if (stack.count() == 0) {
                    return false
                }
                val last = stack.last()!!
                if (s[i] == '}' && last == '{') {
                    stack.removeLast()
                } else if (s[i] == ']' && last == '[') {
                    stack.removeLast()
                } else if (s[i] == ')' && last == '(') {
                    stack.removeLast()
                } else {
                    return false
                }
            }
        }
        return stack.count() == 0
    }
}
