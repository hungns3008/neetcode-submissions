class Solution {
    fun sortColors(nums: IntArray) {
        var temp = HashMap<Int, Int>()
        for (num in nums) {
            temp[num] = (temp[num] ?: 0) + 1
        }
        var currentIndex = 0
        for (i in 0 ..< 3) {
            while (temp[i] != null && temp[i]!! > 0) {
                temp[i] = (temp[i] ?: 0) - 1
                nums[currentIndex] = i
                currentIndex += 1
            }
        }
    }
}
