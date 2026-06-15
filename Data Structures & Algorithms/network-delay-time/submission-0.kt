class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {

        var adjList = HashMap<Int, MutableList<List<Int>>>()

        for (i in 1 .. n) {
            adjList[i] = mutableListOf()
        }

        for (time in times) {
            adjList[time[0]]!!.add(listOf(time[1], time[2]))
        }

        var minHeap = PriorityQueue<List<Int>>(Comparator<List<Int>>() { c1, c2 -> 
            c1[1] - c2[1]
        }) 

        minHeap.add(listOf(k, 0))
        var visited = HashSet<Int>()
        var output = Int.MIN_VALUE

        while (minHeap.count() > 0) {
            var node = minHeap.poll()!!
            var src = node[0]
            var time = node[1]
            if (visited.contains(src)) {
                continue
            }
            visited.add(src)
            output = maxOf(output, time)
            var neighbors = adjList[src] ?: listOf()
            for (neighbor in neighbors) {
                minHeap.add(listOf(neighbor[0], time + neighbor[1]))
            }
        }

        if (visited.count() != n) {
            return -1
        }

        return output

    }
}
