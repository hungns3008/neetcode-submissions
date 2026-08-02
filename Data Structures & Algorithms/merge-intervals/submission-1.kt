class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        intervals.sortWith(Comparator<IntArray>() { c1, c2 ->
            if (c1[0] == c2[0]) {
                c1[1] - c2[1]
            } else {
                c1[0] - c2[0]
            }
        })

        var queue = mutableListOf<IntArray>()
        queue.add(intervals[0])

        var i = 1
        while (i < intervals.count()) {
            var last = queue.last()
            var current = intervals[i]

            if (current[0] <= last[1]) {
                var start = minOf(last[0], current[0])
                var end = maxOf(last[1], current[1])
                queue.removeLast()
                queue.add(intArrayOf(start, end))
            } else {
                queue.add(current)
            }
            i += 1
        }

        return queue.toTypedArray()

    }
}
