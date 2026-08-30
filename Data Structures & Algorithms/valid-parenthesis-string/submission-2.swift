class Solution {
    func checkValidString(_ s: String) -> Bool {
        var cache = [String: Bool]()

        let arrS = Array(s)

        func dfs(_ o: Int, _ c: Int, _ i: Int) -> Bool {

            if i >= arrS.count {
                return o == c
            }

            let key = "\(o),\(c),\(i)"
            if cache[key] != nil {
                return cache[key]!
            }

            if c <= o {
                var ch = arrS[i]
                var isValid = false
                if ch == Character("*") {
                    isValid = dfs(o, c, i + 1) || dfs(o + 1, c, i + 1) || dfs(o, c + 1, i + 1)
                } else if ch == Character("(") {
                    isValid = dfs(o + 1, c, i + 1)
                } else {
                    isValid = dfs(o, c + 1, i + 1)
                }
                cache[key] = isValid
            } else {
                cache[key] = false
            }
            return cache[key]!

        }

        return dfs(0, 0, 0)
    }
}