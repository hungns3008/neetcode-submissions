class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.count() - 1
        while (left < right) {
            val sum = numbers[left] + numbers[right]
            if (sum == target) {
                return intArrayOf(left + 1, right + 1)
            } else if (sum > target) {
                right -= 1
            } else {
                left += 1
            }
        }
        return intArrayOf()
    }
}
