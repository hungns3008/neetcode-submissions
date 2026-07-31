class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        var temp = mutableListOf<Int>()

        fun backtrack(i: Int) {
            if (i == nums.size) {
                res.add(temp.toList())
                return
            }

            temp.add(nums[i])
            backtrack(i + 1)
            
            temp.removeLast()
            
            var j = i + 1
            while (j< nums.count() && nums[j] == nums[j - 1]) {
                j += 1
            }
            backtrack(j)

        }

        backtrack(0)
        return res.toList()
    }
}
