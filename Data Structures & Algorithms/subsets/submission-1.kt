class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        
        var result = mutableListOf<List<Int>>()

        var temp = mutableListOf<Int>()

        fun backtrack(i: Int) {
            if (i >= nums.count()) {
                result.add(temp.toList())
                return
            }
            temp.add(nums[i])
            backtrack(i + 1)

            temp.removeLast()
            backtrack(i + 1)
        }

        backtrack(0)

        return result

    }
}
