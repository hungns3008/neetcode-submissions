class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {

        var output = mutableSetOf<List<Int>>()
        var current = mutableListOf<Int>()

        fun backtrack() {

            if (current.count() == nums.count()) {
                output.add(current.toList())
                return
            }

            for (i in 0 until nums.count()) {

                val temp = nums[i]
                if (temp != Int.MAX_VALUE) {
                    nums[i] = Int.MAX_VALUE
                    current.add(temp)
                    backtrack()
                    current.removeLast()
                    nums[i] = temp
                }
                
            }

        }

        backtrack()

        return output.toList()

    }
}
