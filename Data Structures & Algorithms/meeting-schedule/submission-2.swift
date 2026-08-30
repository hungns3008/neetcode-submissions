/**
 * Definition of Interval:
 * class Interval {
 *     var start: Int
 *     var end: Int
 *     init(_ start: Int, _ end: Int) {
 *         self.start = start
 *         self.end = end
 *     }
 * }
 */

class Solution {
    func canAttendMeetings(_ intervals: [Interval]) -> Bool {
        if intervals.isEmpty { return true }
        let sorted = intervals.sorted { a, b in 
            if a.start == b.start {
                return a.end < b.end
            } else {
                return a.start < b.start
            }
        }
        var lastMeeting = sorted[0]
        for i in 1 ..< sorted.count {
            let current = sorted[i]
            if current.start >= lastMeeting.end {
                lastMeeting = current
            }
            else {
                return false
            }
        }
        return true
    }
}
