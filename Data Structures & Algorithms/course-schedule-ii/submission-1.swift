class Solution {
    func findOrder(_ numCourses: Int, _ prerequisites: [[Int]]) -> [Int] {

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
        var output = [Int]()

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
            output.append(course)

            return true
        }

        for i in 0 ..< numCourses {
            if !dfs(i) {
                return []
            }
        }

        if visited.count == numCourses {
            return output
        }

        return []

    }
}
