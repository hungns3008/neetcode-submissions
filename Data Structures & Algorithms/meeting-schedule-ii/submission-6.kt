/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        if (intervals.isEmpty()) {
            return 0
        }
        val sorted = intervals.toMutableList().sortedWith(Comparator<Interval>() { c1, c2 -> 
            if (c1.start == c2.start) {
                c1.end - c2.end
            } else {
                c1.start - c2.start
            }
        })
        if (intervals.count() <= 1) {
            return 1
        }
        var queue = PriorityQueue<Interval>(Comparator<Interval>() { c1, c2 -> 
            c1.end - c2.end
        })

        queue.add(sorted[0])
        var i = 1
        while (i < sorted.count()) {
            var currentMeeting = queue.peek()!!
            var nextMeeting = sorted[i]

            if (currentMeeting.end <= nextMeeting.start) {
                queue.poll()
            }
            queue.add(nextMeeting)

            i += 1
        }
        return queue.size
    }
}