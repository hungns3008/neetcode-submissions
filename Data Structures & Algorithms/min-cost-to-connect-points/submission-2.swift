class Solution {
    func minCostConnectPoints(_ points: [[Int]]) -> Int {

        func distance(_ p1: [Int], _ p2: [Int]) -> Int {
            return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])
        }

        var output = 0

        var adjList = [Int: [[Int]]]()

        for i in 0 ..< points.count {
            if adjList[i] == nil {
                adjList[i] = []
            }
            for j in i + 1 ..< points.count {
                if adjList[j] == nil {
                    adjList[j] = []
                }
                let distance = distance(points[i], points[j])
                adjList[i]!.append([j, distance])
                adjList[j]!.append([i, distance])
            }
        }

        struct Distance: Comparable {
            var dst: Int
            var cost: Int
            static func < (d1: Distance, d2: Distance) -> Bool {
                return d1.cost < d2.cost
            }
        }

        var minHeap = Heap<Distance>()
        var visited = Set<Int>()
        minHeap.insert(Distance(dst: 0, cost: 0))

        while minHeap.count > 0 {
            var temp = minHeap.popMin()!
            var dest = temp.dst
            var cost = temp.cost
            if visited.contains(dest) {
                continue
            }
            visited.insert(dest)
            output += cost
            var neighbors = adjList[dest] ?? []
            for neighbor in neighbors {
                let node = neighbor[0]
                let nodeCost = neighbor[1]
                if !visited.contains(node) {
                    minHeap.insert(Distance(dst: node, cost: nodeCost))
                }
            }
        }

        return output

    }
}
