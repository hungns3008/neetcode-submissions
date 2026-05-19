class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        var output = mutableListOf<List<Int>>()

        var current = mutableListOf<Int>()
        fun backtrack(i: Int) {
            if (i >= nums.count()) {
                output.add(current.toList())
                return
            }
            current.add(nums[i])
            backtrack(i + 1)

            current.removeLast()

            backtrack(i + 1)
        }

        backtrack(0)

        return output
    }
}
