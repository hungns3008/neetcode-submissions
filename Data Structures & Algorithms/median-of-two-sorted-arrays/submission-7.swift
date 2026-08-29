class Solution {
    func findMedianSortedArrays(_ nums1: [Int], _ nums2: [Int]) -> Double {
        var a = nums1
        var b = nums2
        if nums1.count > nums2.count {
            a = nums2
            b = nums1
        }
        var total = a.count + b.count
        var half = total / 2
        var left = 0
        var right = a.count - 1
        while true {
            var i = Int(floor(Double(left + right) / 2.0))
            var j = half - i - 2

            var aLeft = i >= 0 ? a[i] : Int.min
            var aRight = (i + 1) < a.count ? a[i + 1] : Int.max

            var bLeft = j >= 0 ? b[j] : Int.min
            var bRight = (j + 1) < b.count ? b[j + 1] : Int.max

            if aLeft <= bRight && bLeft <= aRight {
                if total % 2 != 0 {
                    return Double(min(aRight, bRight))
                } else {
                    return Double(max(aLeft, bLeft) + min(aRight, bRight)) / 2.0
                }
            } else if aLeft > bRight {
                right = i - 1
            } else {
                left = i + 1
            }
        }

        return -1.0
    }
}
