class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {

        var n1 = m - 1
        var n2 = n - 1
        var currentIndex = m + n - 1

        while (n1 >= 0 && n2 >= 0) {
            if (nums1[n1] >= nums2[n2]) {
                nums1[currentIndex] = nums1[n1]
                n1 -= 1
            } else {
                nums1[currentIndex] = nums2[n2]
                n2 -= 1
            }
            currentIndex -= 1
        }
        while (n2 >= 0) {
            nums1[currentIndex] = nums2[n2]
            n2 -= 1
            currentIndex -= 1
        }
        
    }
}
