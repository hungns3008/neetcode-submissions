class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        var adjList = HashMap<Int, MutableList<Int>>()
        for (i in 0 ..< numCourses) {
            adjList[i] = mutableListOf()
        }
        for (pre in prerequisites) {
            adjList[pre[0]]!!.add(pre[1])
        }
        var path = mutableSetOf<Int>()
        var visited = mutableSetOf<Int>()

        fun dfs(i: Int): Boolean {
            if (visited.contains(i)) {
                return true
            }
            if (path.contains(i)) {
                return false
            }
            path.add(i)
            var neighbors = adjList[i] ?: listOf()
            for (item in neighbors) {
                if (!dfs(item)) {
                    return false
                }
            }
            path.remove(i)
            visited.add(i)
            return true
        }

        for (i in 0 ..< numCourses) {
            if (!dfs(i)) {
                return false
            }
        }

        return visited.count() == numCourses
    }
}
