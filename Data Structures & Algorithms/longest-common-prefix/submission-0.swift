class Solution {
    func longestCommonPrefix(_ strs: [String]) -> String {
        var longestPossible = Int.max
        for i in 0 ..< strs.count {
            longestPossible = min(longestPossible, strs[i].count)
        }
        let arr = strs.map { item in
            Array(item)
        }
        var output = ""
        for i in 0 ..< longestPossible {
            var candidate = arr[0][i]
            for j in 1 ..< arr.count {
                var current = arr[j][i]
                if current != candidate {
                    return output
                }
            }
            output += "\(candidate)"
        }
        return output
    }
}
