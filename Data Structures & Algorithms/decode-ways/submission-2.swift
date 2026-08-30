class Solution {
    func numDecodings(_ s: String) -> Int {

        var setNum = Set<Character>()
        setNum.insert("0")
        setNum.insert("1")
        setNum.insert("2")
        setNum.insert("3")
        setNum.insert("4")
        setNum.insert("5")
        setNum.insert("6")

        var cache = [Int: Int]()
        let arr = Array(s)

        func dfs(_ startIndex: Int) -> Int {

            if startIndex >= s.count {
                return 1
            }

            var currentChar = arr[startIndex]

            if currentChar == "0" {
                return 0
            }

            if cache[startIndex] != nil {
                return cache[startIndex]!
            }

            var way = dfs(startIndex + 1)
            
            if startIndex + 1 < s.count {
                var nextChar = arr[startIndex + 1]
                var nextCharAscii = nextChar.asciiValue!
                if currentChar == Character("1") && nextCharAscii >= Character("0").asciiValue! && nextCharAscii <= Character("9").asciiValue! {
                    way += dfs(startIndex + 2)
                } else if currentChar == Character("2") && nextCharAscii >= Character("0").asciiValue! && nextCharAscii <= Character("6").asciiValue! {
                    way += dfs(startIndex + 2)
                }
            } 

            cache[startIndex] = way

            return cache[startIndex]!

        }

        return dfs(0)

    }
}
