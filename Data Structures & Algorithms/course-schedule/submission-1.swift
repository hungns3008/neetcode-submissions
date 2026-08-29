class Solution {
    func canFinish(_ numCourses: Int, _ prerequisites: [[Int]]) -> Bool {

        var adjList = [Int: [Int]]()

        for pre in prerequisites {
            let src = pre[0]
            let dst = pre[1]
            if adjList[src] == nil {
                adjList[src] = []
            }
            adjList[src]!.append(dst)
        }

        var visited = Set<Int>()
        var path = Set<Int>()

        func dfs(_ course: Int) -> Bool {
            if path.contains(course) {
                return false
            }
            if visited.contains(course) {
                return true
            }
            path.insert(course)
            
            let neighbors = adjList[course] ?? []
            for neighbor in neighbors {
                if !dfs(neighbor) {
                    return false
                }
            }

            path.remove(course)
            visited.insert(course)

            return true
        }

        for i in 0 ..< numCourses {
            if !dfs(i) {
                return false
            }
        }

        return visited.count == numCourses

    }
}
