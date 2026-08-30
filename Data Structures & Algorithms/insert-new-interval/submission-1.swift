class Solution {
    func insert(_ intervals: [[Int]], _ newInterval: [Int]) -> [[Int]] {

        var res = [[Int]]()
        var i = 0

        while i < intervals.count && intervals[i][1] < newInterval[0] {
            res.append(intervals[i])
            i += 1
        }

        var newStart = newInterval[0]
        var newEnd = newInterval[1]
        while i < intervals.count && newEnd >= intervals[i][0] {
            newStart = min(newStart, intervals[i][0])
            newEnd = max(newEnd, intervals[i][1])
            i += 1
        }
        res.append([newStart, newEnd])

        while i < intervals.count {
            res.append(intervals[i])
            i += 1
        }

        return res

    }
}
