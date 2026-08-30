class Solution {
    func foreignDictionary(_ words: [String]) -> String {
        var adj = [Character: Set<Character>]()
        for w in words {
            let arr = Array(w)
            for c in arr {
                if adj[c] == nil {
                    adj[c] = Set<Character>()
                }
            }
        }
        for i in 0 ..< words.count - 1 {
            let w1 = words[i]
            let w2 = words[i + 1]
            let minLen = min(w1.count, w2.count)

            let substring1 = w1[w1.startIndex..<w1.index(w1.startIndex, offsetBy: minLen)]
            let substring2 = w2[w2.startIndex..<w2.index(w2.startIndex, offsetBy: minLen)]

            if (w1.count > w2.count && substring1 == substring2) {
                return ""
            }
            for j in 0 ..< minLen {
                let arr1 = Array(w1)
                let arr2 = Array(w2)
                if arr1[j] != arr2[j] {
                    adj[arr1[j]]!.insert(arr2[j])
                    break
                }
            }
        }

        var visited = Set<Character>()
        var path = Set<Character>()
        var res = [Character]()

        func dfs(_ char: Character) -> Bool {
            if path.contains(char) {
                return false
            }
            if visited.contains(char) {
                return true
            }
            path.insert(char)
            let neighbors = adj[char] ?? Set<Character>()
            for neighChar in neighbors {
                if !dfs(neighChar) {
                    return false
                }
            }
            path.remove(char)
            visited.insert(char)
            res.append(char)
            return true
        }

        for char in adj.keys {
            if !dfs(char) {
                return ""
            }
        }
        return String(res.reversed())
    }
}
