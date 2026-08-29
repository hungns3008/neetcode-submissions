class Solution {
    func numIslands(_ grid: [[Character]]) -> Int {

        var visited = Set<String>()
        var counter = 0

        func dfs(_ r: Int, _ c: Int) {
            if r >= 0 && r < grid.count && c >= 0 && c < grid[0].count && !visited.contains("\(r)-\(c)") && grid[r][c] == "1" {
                visited.insert("\(r)-\(c)")
                dfs(r + 1, c)
                dfs(r - 1, c)
                dfs(r, c + 1)
                dfs(r, c - 1)
            }
        }

        for r in 0 ..< grid.count {
            for c in 0 ..< grid[0].count {
                if !visited.contains("\(r)-\(c)") && grid[r][c] == "1" {
                    counter += 1
                    dfs(r, c)
                }
            }
        }

        return counter

    }
}
