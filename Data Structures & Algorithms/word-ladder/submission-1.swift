class Solution {
    func ladderLength(_ beginWord: String, _ endWord: String, _ wordList: [String]) -> Int {

        var setWord = Set<String>()
        for word in wordList {
            setWord.insert(word)
        }

        if !setWord.contains(endWord) || beginWord == endWord {
            return 0
        }

        var res = 0
        var queue = [String]()
        queue.append(beginWord)

        while queue.count > 0 {
            let size = queue.count
            res += 1
            for i in 0 ..< size {
                let currentWord = queue.removeFirst()
                if currentWord == endWord {
                    return res
                }
                let arr = Array(currentWord)
                for j in 0 ..< arr.count {
                    for k in Character("a").asciiValue! ... Character("z").asciiValue! {
                        var replacedCh = Character(UnicodeScalar(k))
                        if arr[j] == replacedCh {
                            continue
                        }
                        let prefix = String(arr[0..<j])
                        let suffix = j + 1 < arr.count ? String(arr[(j + 1)...]) : ""
                        let replacedWord = prefix + String(replacedCh) + suffix

                        if setWord.contains(replacedWord) {
                            setWord.remove(replacedWord)
                            queue.append(replacedWord)
                        }
                    }
                }
            }
        }

        return 0

    }
}
