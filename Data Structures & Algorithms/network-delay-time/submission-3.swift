class Solution {
    func networkDelayTime(_ times: [[Int]], _ n: Int, _ k: Int) -> Int {

        var adjList = [Int: [(Int, Int)]]()

        for time in times {
            let src = time[0]
            let dst = time[1]
            let time = time[2]
            if adjList[src] == nil { 
                adjList[src] = []
            }
            adjList[src]!.append((dst, time))
        }

        struct Node: Comparable {
            let dst: Int
            let time: Int

            static func < (n1: Node, n2: Node) -> Bool {
                return n1.time < n2.time
            }
        }

        var minHeap = Heap<Node>()
        minHeap.insert(Node(dst: k, time: 0))

        var visited = Set<Int>()

        while minHeap.count > 0 {
            let node = minHeap.popMin()!
            if visited.contains(node.dst) {
                continue
            }
            visited.insert(node.dst)
            if visited.count == n {
                return node.time
            }
            let neighbors = adjList[node.dst] ?? []
            for neighbor in neighbors {
                minHeap.insert(Node(dst: neighbor.0, time: node.time + neighbor.1))
            }
        }

        return -1

    }
}
