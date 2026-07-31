class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {

        var targetIndex = nums.count() - k

        fun swap(i: Int, j: Int) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        var output = -1

        fun quickSort(left: Int, right: Int) {
            if (output != -1) {
                return
            }
            if (right < left) {
                return
            }

            var pivotIndex = (left..right).random()
            swap(pivotIndex, right)

            var start = left
            for (i in left ..< right) {
                if (nums[i] < nums[right]) {
                    swap(start, i)
                    start += 1
                } 
            }

            swap(start, right)

            if (start == targetIndex) {
                output = nums[start]
            } else if (start > targetIndex) {
                quickSort(left, start - 1)
            } else {
                quickSort(start + 1, right)
            }

        }

        quickSort(0, nums.lastIndex)

        return output

    }
}
