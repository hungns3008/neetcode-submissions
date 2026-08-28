class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {

        func genKey(_ input: String) -> String {

            var temp = Array(repeating: 0, count: 26)

            for ch in input.lowercased() {
                if let ascii = ch.asciiValue {
                    var index = Int(ascii - Character("a").asciiValue!)
                    temp[index] += 1
                }
            }

            var key = ""

            for (index, count) in temp.enumerated() {
                if count > 0 {
                    var ch = String(UnicodeScalar(UInt8(index) + Character("a").asciiValue!))
                    key += "\(ch)\(count)"
                }
            }

            return key

        }

        var hash = [String: [String]]()

        for str in strs {
            var key = genKey(str)
            if hash[key] == nil {
                hash[key] = []
            }
            hash[key]!.append(str)
        }

        var output = [[String]]()
        for (key, words) in hash {
            output.append(words)
        }

        return output

    }
}
