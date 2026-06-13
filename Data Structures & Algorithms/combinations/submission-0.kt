class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {

        var output = mutableListOf<List<Int>>()
        var temp = mutableListOf<Int>()

        fun backtrack(i: Int) {
            if (temp.count() == k) {
                output.add(temp.toList())
                return
            }
            if (i > n) {
                return
            }
            temp.add(i)
            backtrack(i + 1)
            temp.removeLast()

            backtrack(i + 1)
        }

        backtrack(1)

        return output

    }
}
