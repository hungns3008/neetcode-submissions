class Solution {
    fun generateParenthesis(n: Int): List<String> {

        var output = mutableListOf<String>()
        var current = StringBuilder()
        var op = 0
        var cl = 0

        fun backtrack() {
            
            if (op < cl) {
                return
            }

            if (op > n || cl > n) {
                return
            }

            if (op == n && cl == n) {
                output.add(current.toString())
                return
            }

            current.append("(")
            op += 1
            backtrack()

            current.deleteCharAt(current.length - 1)
            op -= 1

            current.append(")")
            cl += 1
            backtrack()

            current.deleteCharAt(current.length - 1)
            cl -= 1

        }

        backtrack()

        return output

    }
}
