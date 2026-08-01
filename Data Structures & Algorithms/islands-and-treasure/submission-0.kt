class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {

        var queue = LinkedList<IntArray>()

        for (i in 0 until grid.count()) {
            for (j in 0 until grid[0].count()) {
                if (grid[i][j] == 0) {
                    queue.add(intArrayOf(i, j))
                }
            }
        }

        var directions = listOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        while (queue.count() > 0) { 
            var size = queue.count()
            for (i in 0 until size) {
                var current = queue.removeFirst()
                var x = current[0]
                var y = current[1]
                for (direction in directions) {
                    var newX = x + direction[0]
                    var newY = y + direction[1]
                    if (newX < 0 || newY < 0 || newX >= grid.count() || newY >= grid[0].count() || grid[newX][newY] != Int.MAX_VALUE) {
                        continue
                    }
                    
                    grid[newX][newY] = grid[x][y] + 1
                    queue.addLast(intArrayOf(newX, newY))
                }
            }
        }

    }
}