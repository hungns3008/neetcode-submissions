class Solution {
    func wordBreak(_ s: String, _ wordDict: [String]) -> Bool {

        var wordSet = Set<String>()
        var cache = [Int: Bool]()

        for word in wordDict {
            wordSet.insert(word)
        }

        func dfs(_ i: Int) -> Bool {
            if i >= s.count {
                return true
            }

            if cache[i] != nil {
                return cache[i]!
            }

            for j in i + 1 ... s.count {
                let startIndex = s.index(s.startIndex, offsetBy: i)
                let endIndex = s.index(s.startIndex, offsetBy: j)
                var substring = String(s[startIndex ..< endIndex])
                if wordSet.contains(substring) {
                    if (dfs(j)) {
                        cache[i] = true
                        return true
                    }
                }
            }

            cache[i] = false
            return false

        }

        return dfs(0)

    }
}
