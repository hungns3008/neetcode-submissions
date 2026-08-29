class Solution {
    func maxAreaOfIsland(_ grid: [[Int]]) -> Int {

        var visited = Set<String>()
        var maxArea = 0

        func dfs(_ r: Int, _ c: Int) -> Int {
            var area = 0
            if r >= 0 && r < grid.count && c >= 0 && c < grid[0].count && !visited.contains("\(r)-\(c)") && grid[r][c] == 1 {
                visited.insert("\(r)-\(c)")
                area = 1 + dfs(r + 1, c) + dfs(r - 1, c) + dfs(r, c + 1) + dfs(r, c - 1)
            }
            return area
        }

        for r in 0 ..< grid.count {
            for c in 0 ..< grid[0].count {
                if !visited.contains("\(r)-\(c)") && grid[r][c] == 1 {
                    maxArea = max(maxArea, dfs(r, c))
                }
            }
        }

        return maxArea

    }
}
