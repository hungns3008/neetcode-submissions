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
    func minMeetingRooms(_ intervals: [Interval]) -> Int {
        if intervals.count == 0 {
            return 0
        }
        let sorted = intervals.sorted { a, b in 
            if a.start == b.start {
                return a.end < b.end
            } else {
                return a.start < b.start
            }
        }
        struct IntervalC: Comparable, Equatable {
            let interval: Interval

            static func < (i1: IntervalC, i2: IntervalC) -> Bool {
                return i1.interval.end < i2.interval.end
            }

            static func == (i1: IntervalC, i2: IntervalC) -> Bool {
                return i1.interval === i2.interval
            }
        }
        var minHeap = Heap<IntervalC>()
        minHeap.insert(IntervalC(interval: sorted[0]))
        for i in 1 ..< sorted.count {
            var lastMeeting = minHeap.min!
            var currentMeeting = sorted[i]

            if lastMeeting.interval.end <= currentMeeting.start {
                _ = minHeap.popMin()
            }
            minHeap.insert(IntervalC(interval: currentMeeting))
        }
        return minHeap.count
    }
}
