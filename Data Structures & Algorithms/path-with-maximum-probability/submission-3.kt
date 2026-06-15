class Solution {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start_node: Int, end_node: Int): Double {

        var adjList = HashMap<Double, MutableList<DoubleArray>>()
        var minHeap = PriorityQueue<DoubleArray>(Comparator<DoubleArray>() { c1, c2 -> 
            if (c1[1] < c2[1]) {
                1
            } else if (c1[1] > c2[1]) {
                -1
            } else {
                0
            }
        })

        for (i in 0 ..< n) {
            adjList[i.toDouble()] = mutableListOf()
        }

        var visited = HashSet<Double>()

        for (i in 0 until edges.count()) {
            var src = edges[i][0].toDouble()
            var dest = edges[i][1].toDouble()
            var prob = succProb[i]
            adjList[src]!!.add(doubleArrayOf(dest, prob))
            adjList[dest]!!.add(doubleArrayOf(src, prob))
        }
        minHeap.add(doubleArrayOf(start_node.toDouble(), 1.0))
        while (minHeap.count() > 0) {
            var node = minHeap.poll()!!
            var src = node[0]
            var probality = node[1]
            if (visited.contains(src)) {
                continue
            }
            if (src == end_node.toDouble()) {
                return probality
            }
            visited.add(src)
            var neighbors = adjList[src] ?: listOf()
            for (neighbor in neighbors) {
                minHeap.add(doubleArrayOf(neighbor[0], neighbor[1] * probality))
            }
        }
        return 0.0
    }
}