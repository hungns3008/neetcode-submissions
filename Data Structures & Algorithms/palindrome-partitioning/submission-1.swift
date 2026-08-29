class Solution {
    func partition(_ s: String) -> [[String]] {
        

        func isPali(_ left: Int, _ right: Int) -> Bool {
            let arr = Array(s)
            var l = left
            var r = right
            while l < r {
                if arr[l] == arr[r] {
                    l += 1
                    r -= 1
                    continue
                }
                return false
            }
            return true
        }

        var output = [[String]]()
        var temp = [String]()

        func dfs(_ startIndex: Int) {
            if startIndex == s.count {
                output.append(temp)
                return
            }
            for endIndex in startIndex ..< s.count {
                if isPali(startIndex, endIndex) {
                    let start = s.index(s.startIndex, offsetBy: startIndex)
                    let end = s.index(s.startIndex, offsetBy: endIndex)
                    let substring = s[start...end]
                    temp.append(String(substring))
                    dfs(endIndex + 1)
                    temp.removeLast()
                }
            }
        }

        dfs(0)

        return output

    }
}
