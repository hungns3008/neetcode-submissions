class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        var minHeap = PriorityQueue<IntArray>(Comparator<IntArray>() { c1, c2 -> 
            c1[2] - c2[2]
        })

        var visited = HashSet<String>()
        var directions = listOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        minHeap.add(intArrayOf(0, 0, grid[0][0]))

        while (minHeap.count() > 0) {
            var node = minHeap.poll()!!
            var x = node[0]
            var y = node[1]
            var time = node[2]
            if (visited.contains("${x}-${y}")) {
                continue
            }
            if (x == grid.count() - 1 && y == grid[0].count() - 1) {
                return time
            }
            visited.add("${x}-${y}")
            for (direction in directions) {
                var newX = direction[0] + x
                var newY = direction[1] + y
                if (newX >= 0 && 
                    newY >= 0 && 
                    newX < grid.count() && 
                    newY < grid[0].count() && 
                    !visited.contains("${newX}-${newY}")) {
                    var nextElevation = grid[newX][newY]
                    minHeap.add(intArrayOf(newX, newY, max(time, nextElevation)))
                }
            }
        }

        return -1
    }
}