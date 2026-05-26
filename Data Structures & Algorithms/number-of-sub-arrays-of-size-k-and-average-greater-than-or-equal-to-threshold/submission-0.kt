class Solution {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        var left = 0
        var right = 0
        var currentSum = 0
        var output = 0
        while (right < arr.count()) {
            currentSum += arr[right]
            if (right - left + 1 == k) {

                if (currentSum.toFloat() / k.toFloat() >= threshold.toFloat()) {
                    output += 1
                }
                currentSum -= arr[left]
                left += 1

            }
            right += 1
        }
        return output
    }
}
