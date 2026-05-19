class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {

        var output = mutableListOf<List<Int>>()

        var arr = mutableListOf<Int>()

        fun backtrack(i: Int, current: Int) {
            if (current == target) {
                output.add(arr.toList())
                return
            }
            if (i >= nums.count() || current > target) {
                return
            }
            // choose
            arr.add(nums[i])
            backtrack(i, current + nums[i])
            // skip
            arr.removeLast()
            backtrack(i + 1, current)
        }

        backtrack(0, 0)

        return output
    }
}
