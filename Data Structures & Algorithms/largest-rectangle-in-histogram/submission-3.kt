class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var queue = mutableListOf<IntArray>()
        var output = 0
        for (i in 0 until heights.count()) {
            val currentHeight = heights[i]
            var currentIndex = i
            while (queue.count() > 0 && queue.last()[1] > currentHeight) {
                val last = queue.removeLast()
                val size = i - last[0]
                val square = size * last[1]
                output = maxOf(output, square)
                currentIndex = last[0]
            }
            queue.add(intArrayOf(currentIndex, currentHeight))

        }
        for (i in 0 until queue.count()) {
            output = maxOf(output, (heights.count() - queue[i][0]) * queue[i][1])
        }
        return output
    }
}
