class Solution {
    func minDistance(_ word1: String, _ word2: String) -> Int {

        var cache = [String: Int]()
        let w1 = Array(word1)
        let w2 = Array(word2)

        func dfs(_ i: Int, _ j: Int) -> Int {

            if i == word1.count && j == word2.count {
                return 0
            }
            if i == word1.count {
                return word2.count - j
            }
            if j == word2.count {
                return word1.count - i
            }
            if cache["\(i)-\(j)"] != nil {
                return cache["\(i)-\(j)"]!
            }
            if w1[i] == w2[j] {
                cache["\(i)-\(j)"] = dfs(i + 1, j + 1)
            } else {
                // replace 
                let way1 = 1 + dfs(i + 1, j + 1)
                // insert
                let way2 = 1 + dfs(i, j + 1)
                // delete
                let way3 = 1 + dfs(i + 1, j)

                cache["\(i)-\(j)"] = min(way1, way2, way3)
            }

            return cache["\(i)-\(j)"]!
        }

        return dfs(0, 0)

    }
}
