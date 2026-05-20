class Solution {
    fun rob(nums: IntArray): Int {

        var cache = HashMap<String, Int>()

        fun dfs(i: Int, money: Int): Int {
            if (i >= nums.count()) {
                return money
            }
            if (cache["${i}-${money}"] != null) { 
                return cache["${i}-${money}"]!!
            }
            cache["${i}-${money}"] = maxOf(
                dfs(i + 1, money),
                dfs(i + 2, money + nums[i])
            )
            return cache["${i}-${money}"]!!
        }

        return dfs(0, 0)

    }
}
