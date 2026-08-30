class Solution {
    func longestIncreasingPath(_ matrix: [[Int]]) -> Int {
        var directions = [
            [0, 1],
            [0, -1],
            [1, 0],
            [-1, 0]
        ]

        var cache = [String: Int]()

        func dfs(_ r: Int, _ c: Int) -> Int {
            if cache["\(r)-\(c)"] != nil {
                return cache["\(r)-\(c)"]!
            }
            
            var res = 1
            for direction in directions {
                var newR = r + direction[0]
                var newC = c + direction[1]
                if newR >= 0 && newR < matrix.count && newC >= 0 && newC < matrix[0].count && 
                matrix[newR][newC] > matrix[r][c] {
                    res = max(res, 1 + dfs(newR, newC))
                }
            }
            cache["\(r)-\(c)"] = res
            return cache["\(r)-\(c)"]!
        }

        var output = 0
        for r in 0 ..< matrix.count {
            for c in 0 ..< matrix[0].count {
                output = max(output, dfs(r, c))
            }
        }
        return output
    }
}
