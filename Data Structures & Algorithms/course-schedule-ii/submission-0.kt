class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

        var adjList = HashMap<Int, MutableList<Int>>()
        for (i in 0 until numCourses) {
            adjList[i] = mutableListOf()
        }

        for (pre in prerequisites) {
            adjList[pre[0]]!!.add(pre[1])
        }

        var path = mutableSetOf<Int>()
        var visited = mutableSetOf<Int>()
        var output = mutableListOf<Int>()

        fun dfs(i: Int): Boolean {
            if (visited.contains(i)) {
                return true
            }
            if (path.contains(i)) {
                return false
            }
            path.add(i)
            var neighbors = adjList[i] ?: listOf()
            for (node in neighbors) {
                if (!dfs(node)) {
                    return false
                }
            }
            path.remove(i)
            visited.add(i)
            output.add(i)
            return true
        }

        for (course in 0 until numCourses) {
            if (!dfs(course)) {
                return intArrayOf()
            }
        }

        return output.toIntArray()

    }
}
