class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        var cans = candidates.sorted()

        var output = mutableListOf<List<Int>>()

        var temp = mutableListOf<Int>()
        fun backtrack(i: Int, current: Int) {
            if (current == target) {
                output.add(temp.toList())
                return
            }
            if (i >= cans.count() || current > target) {
                return
            }
            temp.add(cans[i])
            backtrack(i + 1, cans[i] + current)

            // skip
            temp.removeLast()
            var j = i + 1
            while (j< cans.count() && cans[j] == cans[j - 1]) {
                j += 1
            }
            backtrack(j, current) 
        }

        backtrack(0, 0)

        return output
    }
}
