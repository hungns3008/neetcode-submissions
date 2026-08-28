class Solution {

    func encode(_ strs: [String]) -> String {
        // Hello World
        // 5#Hello5#World
        var output = ""
        for str in strs {
            output += "\(str.length)#\(str)"
        }
        return output
    }

    func decode(_ str: String) -> [String] {

        var output = [String]()
        var arrStr = Array(str)

        // 5#Hello5#World
        var i = 0
        while i < arrStr.count {
            var tempCh = ""
            while arrStr[i] != "#" {
                tempCh += "\(arrStr[i])"
                i += 1
            }
            var num = Int(tempCh)!
            let startIndex = i + 1
            let endIndex = startIndex + num
            var currentString = ""
            for j in startIndex ..< endIndex {
                currentString += "\(arrStr[j])"
            }
            i = endIndex
            output.append(currentString)
        }
        return output

    }
}
