class Solution {
    func partitionLabels(_ s: String) -> [Int] {
        // hash ch: [first position, very last position]
        // if there is only first pos it means that this is only single ch
        // if there are 2 pos, it means we have to substring s from first and last (so character wont appear twice)

        let arrS = Array(s)

        var output = [Int]()

        var hash = [Character: [Int]]()

        for i in 0 ..< s.count {
            let ch = arrS[i]
            if hash[ch] == nil {
                hash[ch] = []
            }
            if hash[ch]!.count == 1 {
                hash[ch]!.append(i)
            } else if hash[ch]!.count == 2 {
                hash[ch]![1] = i
            } else {
                hash[ch]!.append(i)
            }

        }

        func dfs(_ startIndex: Int) {

            if startIndex >= s.count {
                return
            }
            let ch = arrS[startIndex]
            let arr = hash[ch] ?? []

            if arr.count == 1 {
                output.append(1)
                dfs(startIndex + 1)
            } else {
                var lastIndex = arr[1]
                var i = startIndex + 1
                while i <= lastIndex {
                    if let nextArr = hash[arrS[i]] {
                        lastIndex = max(lastIndex, nextArr[nextArr.count - 1])
                    }
                    i += 1
                }
                output.append(lastIndex - startIndex + 1)
                dfs(lastIndex + 1)
            }

        }

        dfs(0)

        return output
    }
}
