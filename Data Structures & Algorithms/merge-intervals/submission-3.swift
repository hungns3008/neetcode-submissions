class Solution {
    func merge(_ intervals: [[Int]]) -> [[Int]] {
        var sorted = intervals.sorted { a, b in 
            if a[0] == b[0] {
                a[1] < b[1]
            } else {
                a[0] < b[0]
            }
        }

        var output = [[Int]]()
        output.append(sorted[0])

        for i in 1 ..< sorted.count {
            var last = output[output.count - 1]
            var current = sorted[i]
            if last[1] >= current[0] {
                output.removeLast()
                output.append([min(last[0], current[0]), max(last[1], current[1])])
            } else {
                output.append(current)
            }
        }

        return output

    }
}
