class Solution {
    func largestRectangleArea(_ heights: [Int]) -> Int {

        var queue = [(Int, Int)]() // increasing queue (position, height)

        var output = 0

        for i in 0 ..< heights.count {
            var currentHeight = heights[i]
            var currentIndex = i
            while queue.count > 0 && queue.last!.1 > currentHeight {
                var last = queue.removeLast()
                var size = (i - last.0) * last.1
                output = max(output, size)
                currentIndex = last.0
            }
            queue.append((currentIndex, currentHeight))
        }

        for i in 0 ..< queue.count {
            var position = queue[i].0
            var height = queue[i].1
            output = max(output, (heights.count - position) * height)
        }

        return output

    }
}
