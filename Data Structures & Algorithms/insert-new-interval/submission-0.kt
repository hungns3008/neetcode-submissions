class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        val res = mutableListOf<IntArray>()
        var i = 0
        val n = intervals.size

        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i])
            i++
        }

        var newStart = newInterval[0]
        var newEnd = newInterval[1]
        while (i < n && newEnd >= intervals[i][0]) {
            newStart = minOf(newStart, intervals[i][0])
            newEnd = maxOf(newEnd, intervals[i][1])
            i++
        }
        res.add(intArrayOf(newStart, newEnd))

        while (i < n) {
            res.add(intervals[i])
            i++
        }

        return res.toTypedArray()

    }
}
