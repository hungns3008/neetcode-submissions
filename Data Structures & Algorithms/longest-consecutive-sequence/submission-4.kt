class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.count() == 0) {
            return 0
        }
        var hash = mutableSetOf<Int>()
        var output = 1
        for (num in nums) {
            hash.add(num)
        }
        for (num in nums) {
            if (hash.contains(num - 1)) {
                continue
            }
            var temp = num
            var counter = 1
            while (hash.contains(temp + 1)) {
                counter += 1
                temp += 1
                output = maxOf(output, counter)
            }
        }
        return output
    }
}
