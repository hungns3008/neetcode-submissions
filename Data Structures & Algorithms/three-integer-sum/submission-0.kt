class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        var sorted = nums.sorted()
        var output = mutableListOf<List<Int>>()

        for (i in 0 until sorted.count()) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                var target = 0 - sorted[i]
                // do 2Sum
                var left = i + 1
                var right = sorted.count() - 1
                while (left < right) {
                    if (sorted[left] + sorted[right] > target) {
                        right -= 1
                    } else if (sorted[left] + sorted[right] < target) {
                        left += 1
                    } else {
                        output.add(listOf(sorted[i], sorted[left], sorted[right]))
                        left += 1
                        right -= 1
                        while (left < right && sorted[left] == sorted[left - 1]) {
                            left += 1
                        }
                    }
                }
            }
        }

        return output
    }
}
