class Solution {
    func findCheapestPrice(_ n: Int, _ flights: [[Int]], _ src: Int, _ dst: Int, _ k: Int) -> Int {

        var adjList = [Int: [[Int]]]()

        for i in 0 ..< n {
            adjList[i] = []
        }

        for flight in flights {
            adjList[flight[0]]!.append([flight[1], flight[2]])
        }

        struct Stop: Comparable {
            let src: Int
            let cost: Int
            let stop: Int

            static func < (s1: Stop, s2: Stop) -> Bool {
                return s1.cost < s2.cost
            }
        }

        var minHeap = Heap<Stop>()
        minHeap.insert(Stop(src: src, cost: 0, stop: 0))
        
        // Track minimum stops taken to reach an airport to avoid redundant cycles/paths
        var minStops = Array(repeating: Int.max, count: n)

        while minHeap.count > 0 {
            let node = minHeap.popMin()!
            let airport = node.src
            let cost = node.cost
            let stop = node.stop
            
            if (airport == dst) {
                return cost
            }
            
            if (stop > k || stop >= minStops[airport]) {
                continue
            }
            
            minStops[airport] = stop
            
            var neighbors = adjList[airport] ?? []
            for neighbor in neighbors {
                minHeap.insert(Stop(src: neighbor[0], cost: neighbor[1] + cost, stop: stop + 1))
            }
        }
        
        return -1

    }
}
