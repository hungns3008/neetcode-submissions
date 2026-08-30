class Solution {
    func swimInWater(_ grid: [[Int]]) -> Int {

        struct Node: Comparable {
            let x: Int
            let y: Int
            let time: Int

            static func < (n1: Node, n2: Node) -> Bool {
                return n1.time < n2.time
            }
        }
        
        var minHeap = Heap<Node>()

        var visited = Set<String>()
        var directions = [
            [0, 1],
            [0, -1],
            [1, 0],
            [-1, 0]
        ]

        minHeap.insert(Node(x: 0, y: 0, time: grid[0][0]))

        while minHeap.count > 0 {
            var node = minHeap.popMin()!
            var x = node.x
            var y = node.y
            var time = node.time
            if (visited.contains("\(x)-\(y)")) {
                continue
            }
            if x == grid.count - 1 && y == grid[0].count - 1 {
                return time
            }
            visited.insert("\(x)-\(y)")
            for direction in directions {
                var newX = direction[0] + x
                var newY = direction[1] + y
                if newX >= 0 && newX < grid.count && 
                newY >= 0 && newY < grid[0].count && !visited.contains("\(newX)-\(newY)") {
                    var nextElevation = grid[newX][newY]
                    minHeap.insert(Node(x: newX, y: newY, time: max(time, nextElevation)))
                }
            }
        }

        return -1

    }
}