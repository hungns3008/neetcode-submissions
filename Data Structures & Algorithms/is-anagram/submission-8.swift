class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {

        if s.count != t.count {
            return false
        }
        var map = [Character: Int]()
        let sArray = Array(s)
        let tArray = Array(t)
        for i in 0 ..< sArray.count {
            let currentChar = sArray[i]
            map[currentChar] = (map[currentChar] ?? 0) + 1
        }

        for i in 0 ..< tArray.count {
            let currentChar = tArray[i]
            if let charCount = map[currentChar] {
                if charCount - 1 == 0 {
                    map.removeValue(forKey: currentChar)
                } else {
                    map[currentChar] = charCount - 1
                }
            } else {
                return false
            }
        }

        return map.count == 0
    }
}