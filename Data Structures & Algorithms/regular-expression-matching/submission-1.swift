class Solution {
    func isMatch(_ s: String, _ p: String) -> Bool {

        let arrS = Array(s)
        let arrP = Array(p)

        var cache = [String: Bool]()

        func dfs(_ i: Int, _ j: Int) -> Bool {
            if let cached = cache["\(i)-\(j)"] {
                return cached
            }

            if j == arrP.count {
                return i == arrS.count
            }

            let match = i < arrS.count && (arrS[i] == arrP[j] || arrP[j] == ".")
            
            let result: Bool
            if j + 1 < arrP.count && arrP[j + 1] == "*" {
                result = dfs(i, j + 2) || (match && dfs(i + 1, j))
            } else {
                result = match && dfs(i + 1, j + 1)
            }

            cache["\(i)-\(j)"] = result
            return result
        }

        return dfs(0, 0)
    }
}