class Solution {
    func numDistinct(_ s: String, _ t: String) -> Int {

        let arrS = Array(s)
        let arrT = Array(t)

        var cache = [String: Int]()

        func dfs(_ i: Int, _ j: Int) -> Int {
            if j == t.count {
                return 1
            }
            if i == s.count {
                return 0
            }
            if cache["\(i)-\(j)"] != nil {
                return cache["\(i)-\(j)"]!
            }
            var way = dfs(i + 1, j)
            if arrS[i] == arrT[j] {
                way += dfs(i + 1, j + 1)
            }
            cache["\(i)-\(j)"] = way
            return cache["\(i)-\(j)"]!
        }

        return dfs(0, 0)
    }
}
