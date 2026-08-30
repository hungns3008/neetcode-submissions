class Solution {
    func uniquePaths(_ m: Int, _ n: Int) -> Int {

        var cache = [String: Int]()

        func dfs(_ r: Int, _ c: Int) -> Int {

            if r == m || c == n {
                return 0
            }

            if r == m - 1 && c == n - 1 {
                return 1
            }

            if cache["\(r)-\(c)"] != nil {
                return cache["\(r)-\(c)"]!
            }

            cache["\(r)-\(c)"] = dfs(r + 1, c) + dfs(r, c + 1)

            return cache["\(r)-\(c)"]!
        }

        return dfs(0, 0)

    }
}
