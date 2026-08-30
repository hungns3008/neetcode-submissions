class Solution {
    func isInterleave(_ s1: String, _ s2: String, _ s3: String) -> Bool {

        let arr1 = Array(s1)
        let arr2 = Array(s2)
        let arr3 = Array(s3)

        if s1.count + s2.count != s3.count {
            return false
        }

        var cache = [String: Bool]()

        func dfs(_ i: Int, _ j: Int, _ k: Int) -> Bool {
            if k >= s3.count {
                return true
            }

            let key = "\(i)-\(j)"

            if cache[key] != nil {
                return cache[key]!
            }

            var c = arr3[k]
            var aMatches = i < arr1.count && arr1[i] == c
            var bMatches = j < arr2.count && arr2[j] == c

            if (aMatches && bMatches) {
                cache[key] = dfs(i + 1, j, k + 1) || dfs(i, j + 1, k + 1)
            } else if (aMatches) {
                cache[key] = dfs(i + 1, j, k + 1)
            } else if (bMatches) {
                cache[key] = dfs(i, j + 1, k + 1)
            } else {
                cache[key] = false
            }
            return cache[key]!
        }


        return dfs(0, 0, 0)

    }
}
