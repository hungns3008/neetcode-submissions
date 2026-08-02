/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        var sorted = intervals.toMutableList().sortedWith(Comparator<Interval>() { c1, c2 -> 
            if (c1.start == c2.start) {
                c1.end - c2.end
            } else {
                c1.start - c2.start
            }
        })

        if (sorted.count() <= 1) {
            return true
        }

        var last = sorted[0]
        var i = 1
        while (i < sorted.count()) {
            var current = sorted[i]
            if (current.start < last.end) {
                return false
            }
            last = current
            i += 1
        }

        return true
    }
}
