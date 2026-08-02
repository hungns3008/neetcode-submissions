class Solution {
    fun lengthOfLIS(nums: IntArray): Int {

        var cache = HashMap<Pair<Int, Int>, Int>()

        fun dfs(i: Int, j: Int): Int {
            if (i == nums.size) {
                return 0
            }

            if (cache[Pair(i, j)] != null) {
                return cache[Pair(i, j)]!!
            }

            var output = dfs(i + 1, j) // not include

            if (j == -1 || nums[j] < nums[i]) {
                output = maxOf(output, 1 + dfs(i + 1, i)) // include
            }

            cache[Pair(i, j)] = output

            return output
        }

        return dfs(0, -1)

    }
}
