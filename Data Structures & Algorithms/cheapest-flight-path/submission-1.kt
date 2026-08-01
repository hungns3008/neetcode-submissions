class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {

        var adjList = HashMap<Int, MutableList<IntArray>>()

        for (i in 0 until n) {
            adjList[i] = mutableListOf()
        }

        for (flight in flights) {
            adjList[flight[0]]!!.add(intArrayOf(flight[1], flight[2]))
        }

        var heap = PriorityQueue<IntArray>(Comparator<IntArray>() { c1, c2 -> 
            c1[1] - c2[1]
        })
        // src, cost, stop
        heap.add(intArrayOf(src, 0, 0))
        
        // Track minimum stops taken to reach an airport to avoid redundant cycles/paths
        val minStops = IntArray(n) { Int.MAX_VALUE }

        while (heap.count() > 0) {
            val node = heap.poll()!!
            val airport = node[0]
            val cost = node[1]
            val stop = node[2]
            
            if (airport == dst) {
                return cost
            }
            
            if (stop > k || stop >= minStops[airport]) {
                continue
            }
            
            minStops[airport] = stop
            
            var neighbors = adjList[airport] ?: listOf()
            for (neighbor in neighbors) {
                heap.add(intArrayOf(neighbor[0], neighbor[1] + cost, stop + 1))
            }
        }
        
        return -1
    }
}