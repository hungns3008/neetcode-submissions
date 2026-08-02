class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
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
        var output = 0
        while (i < intervals.count()) {
            var last = queue.last()
            var current = intervals[i]

            // check overlap
            if (last[1] <= current[0]) {
                queue.add(current)
            } else {
                output += 1
                if (last[1] <= current[1]) {
                    // remove current => do nothing
                } else {
                    // remove last
                    queue.removeLast()
                    queue.add(current)
                }
            }
            i += 1
        }
        return output
    }
}
