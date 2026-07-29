class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.count() == 1) {
            return intArrayOf(nums[0])
        }
        var dequeue = LinkedList<Int>()
        var left = 0
        var right = 0
        var output = mutableListOf<Int>()
        while (right < nums.count()) {
            var current = nums[right]
            while (dequeue.count() > 0 && current > dequeue.last()) {
                dequeue.removeLast()
            }
            dequeue.add(current)
            if (right - left + 1 == k) {
                output.add(dequeue.first())
                if (nums[left] == dequeue.first()) {
                    dequeue.removeFirst()
                }
                left += 1
            }
            right += 1
        }
        return output.toIntArray()
    }
}
