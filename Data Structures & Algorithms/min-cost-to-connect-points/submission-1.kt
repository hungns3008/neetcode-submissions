class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {

        fun distance(p1: IntArray, p2: IntArray): Int {
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1])
        }

        var output = 0

        var adjList = HashMap<Int, MutableList<IntArray>>()

        for (i in 0 until points.count()) {
            if (adjList[i] == null) {
                adjList[i] = mutableListOf()
            }
            for (j in i + 1 until points.count()) {
                if (adjList[j] == null) {
                    adjList[j] = mutableListOf()
                        }
                val distance = distance(points[i], points[j])
                adjList[i]!!.add(intArrayOf(j, distance))
                adjList[j]!!.add(intArrayOf(i, distance))
            }
        }

        var minHeap = PriorityQueue<IntArray>(Comparator<IntArray>() { c1, c2 ->
            c1[1] - c2[1]
        })

        var visited = mutableSetOf<Int>()

        minHeap.add(intArrayOf(0, 0))

        while (minHeap.count() > 0) {
            var temp = minHeap.poll()!!
            var dest = temp[0]
            var cost = temp[1]
            if (visited.contains(dest)) {
                continue
            }
            visited.add(dest)
            output += cost
            var neighbors = adjList[dest] ?: listOf()
            for (neighbor in neighbors) {
                val node = neighbor[0]
                val nodeCost = neighbor[1]
                if (!visited.contains(node)) {
                    minHeap.add(intArrayOf(node, nodeCost))
                }
            }
        }

        return output

    }
}