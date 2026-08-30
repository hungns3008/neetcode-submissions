class Solution {
    func longestCommonSubsequence(_ text1: String, _ text2: String) -> Int {

        let arr1 = Array(text1)
        let arr2 = Array(text2)

        var cache = [String: Int]()

        func dfs(_ i: Int, _ j: Int) -> Int {

            if i == text1.count || j == text2.count {
                return 0
            }

            if cache["\(i)-\(j)"] != nil {
                return cache["\(i)-\(j)"]!
            }

            var lcs = 0

            if arr1[i] == arr2[j] {
                lcs = 1 + dfs(i + 1, j + 1)
            } else {
                lcs = max(dfs(i + 1, j), dfs(i, j + 1))
            }
            cache["\(i)-\(j)"] = lcs

            return lcs
        }

        return dfs(0, 0)

    }
}
