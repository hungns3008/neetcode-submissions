class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var a = nums1
        var b = nums2
        if (nums1.count() > nums2.count()) {
            a = nums2
            b = nums1
        }
        var total = a.count() + b.count() 
        var half = total / 2
        var left = 0
        var right = a.count() - 1
        while (true) {
            var i = Math.floorDiv(left + right, 2)
            if (left > right) i = -1
            var j = half - i - 2
            
            var Aleft = if (i >= 0) a[i] else Int.MIN_VALUE
            var Aright = if (i + 1 < a.count()) a[i + 1] else Int.MAX_VALUE
            var Bleft = if (j >= 0) b[j] else Int.MIN_VALUE
            var Bright = if (j + 1 < b.count()) b[j + 1] else Int.MAX_VALUE

            if (Aleft <= Bright && Bleft <= Aright) {
                return if (total % 2 != 0) {
                    Math.min(Aright.toDouble(), Bright.toDouble())
                } else {
                    (Math.max(Aleft.toDouble(), Bleft.toDouble()) +
                     Math.min(Aright.toDouble(), Bright.toDouble())) / 2.0
                }
            } else if (Aleft > Bright) {
                right = i - 1
            } else {
                left = i + 1
            }
        }
        return -1.0
    }
}
