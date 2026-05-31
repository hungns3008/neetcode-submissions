class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var numSet = mutableSetOf<Int>()
        for (num in nums) {
            numSet.add(num)
        }
        var output = 0
        for (num in nums) {
            if (numSet.contains(num - 1)) {
                continue
            }
            var count = 1
            var current = num
            while (numSet.contains(current + 1)) {
                current += 1
                count += 1
            }
            output = maxOf(output, count)
        }
        return output
    }
}
