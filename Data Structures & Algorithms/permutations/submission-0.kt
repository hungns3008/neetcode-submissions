class Solution {
    fun permute(nums: IntArray): List<List<Int>> {

        fun backtrack(i: Int): List<List<Int>> {
            if (i >= nums.count()) {
                return listOf(listOf())
            }
            val prev = backtrack(i + 1)
            val currentPerms = mutableListOf<List<Int>>()
            for (k in 0 until prev.count()) {
                var prevArr = prev[k]
                for (j in 0 until prevArr.count() + 1) {
                    val temp = prevArr.toMutableList()
                    temp.add(j, nums[i])
                    currentPerms.add(temp.toList())
                }
            }
            return currentPerms
        }

        return backtrack(0).toMutableList()

    }
}
