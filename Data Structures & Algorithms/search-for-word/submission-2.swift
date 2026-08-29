class Solution {
    func exist(_ board: [[Character]], _ word: String) -> Bool {

        var arrWord = Array(word)

        var path = Set<String>()

        func dfs(_ i: Int, _ j: Int, _ currentIndex: Int) -> Bool {

            if currentIndex == arrWord.count {
                return true
            }

            if i >= 0 && i < board.count && j >= 0 && j < board[0].count {
                var currentCh = arrWord[currentIndex]
                if board[i][j] == currentCh && !path.contains("\(i)-\(j)") {
                    path.insert("\(i)-\(j)")
                    
                    var result = dfs(i + 1, j, currentIndex + 1) || 
                    dfs(i, j + 1, currentIndex + 1) || 
                    dfs(i - 1, j, currentIndex + 1) || 
                    dfs(i, j - 1, currentIndex + 1)

                    path.remove("\(i)-\(j)")
                    return result
                }
            }
            return false
        }


        for r in 0 ..< board.count {
            for c in 0 ..< board[0].count {
                if dfs(r, c, 0) {
                    return true
                }
            }
        }

        return false

    }
}
