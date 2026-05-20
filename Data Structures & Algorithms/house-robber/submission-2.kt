class Solution {
    fun rob(nums: IntArray): Int {

        if (nums.count() < 0) {
            return -1
        }

        if (nums.count() == 1) {
            return nums[0]
        }


        var house1 = nums[0]
        var house2 = maxOf(house1, nums[1])

        for (i in 2 ..< nums.count()) {
            val temp = maxOf(nums[i] + house1, house2)
            house1 = house2
            house2 = temp
        }

        return house2

    }
}
