class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        var newNums = IntArray(nums.count() * 2) { 0 }
        for (i in 0 ..< newNums.count()) {
            val index = i % nums.count()
            newNums[i] = nums[index]
        }
        return newNums
    }
}
