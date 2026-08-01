class Solution {
    fun rob(nums: IntArray): Int {

        var cache = HashMap<Int, Int>()

        fun dfs(i: Int): Int {
            if (i >= nums.count()) {
                return 0
            }
            if (cache[i] != null) {
                return cache[i]!!
            }

            // rob at i
            var money1 = nums[i] + dfs(i + 2)
            // skip at i
            var money2 = dfs(i + 1)

            cache[i] = maxOf(money1, money2)

            return cache[i]!!
        }

        return dfs(0)

        // if (nums.count() < 0) {
        //     return -1
        // }

        // if (nums.count() == 1) {
        //     return nums[0]
        // }


        // var house1 = nums[0]
        // var house2 = maxOf(house1, nums[1])

        // for (i in 2 ..< nums.count()) {
        //     val temp = maxOf(nums[i] + house1, house2)
        //     house1 = house2
        //     house2 = temp
        // }

        // return house2

    }
}
