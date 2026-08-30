class Solution {
    func eraseOverlapIntervals(_ intervals: [[Int]]) -> Int {
        if intervals.isEmpty { return 0 }
        var sorted = intervals.sorted { a, b in 
            if a[0] == b[0] {
                return a[1] < b[1]
            } else {
                return a[0] < b[0]
            }
        }

        var queue = [[Int]]()
        queue.append(sorted[0])
        var i = 1
        var output = 0
        while i < sorted.count {
            var last = queue[queue.count - 1]
            var current = sorted[i]

            // check overlap
            if last[1] <= current[0] {
                queue.append(current)
            } else {
                output += 1
                if last[1] <= current[1] {
                    // remove current => do nothing
                } else {
                    // remove last
                    queue.removeLast()
                    queue.append(current)
                }
            }
            i += 1
        }
        return output
    }
}