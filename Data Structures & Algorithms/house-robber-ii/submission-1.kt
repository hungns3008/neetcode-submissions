class Solution {
    fun rob(nums: IntArray): Int {

        if (nums.count() == 1) {
            return nums[0]
        }

        var cache = HashMap<Pair<Int, Boolean>, Int>()

        fun dfs(i: Int, robFirstHouse: Boolean): Int {

            if (robFirstHouse) {
                if (i >= nums.count() - 1) {
                    return 0
                }
            } else {
                if (i >= nums.count()) {
                    return 0
                }
            }

            if (cache[Pair(i, robFirstHouse)] != null) {
                return cache[Pair(i, robFirstHouse)]!!
            }

            cache[Pair(i, robFirstHouse)] = maxOf(nums[i] + dfs(i + 2, robFirstHouse), dfs(i + 1, robFirstHouse))

            return cache[Pair(i, robFirstHouse)]!!

        }

        return maxOf(dfs(0, true), dfs(1, false))

    }
}
