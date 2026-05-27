class Solution {
    fun maxTurbulenceSize(arr: IntArray): Int {
        if (arr.count() == 1) {
            return 1
        }
        var left = 0
        var right = 1
        var output = 1
        var prev = 0

        fun getCurrentSign(): Int {
            return if (arr[right - 1] > arr[right]) {
                    1
                } else if (arr[right - 1] < arr[right]) {
                    -1
                } else {
                    0
                }
        }

        while (right < arr.count()) {
            if (prev == 0) {
                prev = getCurrentSign()
                if (prev == 0) {
                    left = right
                } else {
                    left = right - 1
                }
            } else {
                var current = getCurrentSign()
                if (current * prev < 0) {
                    // do nothing
                } else if (current * prev > 0) {
                    left = right - 1
                } else {
                    left = right
                }
                prev = current
            }
            output = maxOf(output, right - left + 1)
            right += 1
        }
        return output
    }
}
