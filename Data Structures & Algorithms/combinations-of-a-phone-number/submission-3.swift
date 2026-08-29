class Solution {
    func letterCombinations(_ digits: String) -> [String] {
        var hash = [Character: String]()
        hash["2"] = "abc"
        hash["3"] = "def"
        hash["4"] = "ghi"
        hash["5"] = "jkl"
        hash["6"] = "mno"
        hash["7"] = "pqrs"
        hash["8"] = "tuv"
        hash["9"] = "wxyz"

        var output = [String]()
        var temp = [Character]()

        var arrDigits = Array(digits)

        func dfs(_ i: Int) {
            if i == arrDigits.count {
                if temp.count > 0 {
                    output.append(String(temp))
                }
                return
            }
            var currentDigit = arrDigits[i]
            var charSet = hash[currentDigit]!
            var charArr = Array(charSet)
            for j in 0 ..< charArr.count {
                temp.append(charArr[j])
                dfs(i + 1)
                temp.removeLast()
            }
        }

        dfs(0)

        return output
    }
}
