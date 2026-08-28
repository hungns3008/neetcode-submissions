class Solution {
    func isValidSudoku(_ board: [[Character]]) -> Bool {

        let ROW = board.count
        let COL = board[0].count

        func isValidRow(_ row :Int) -> Bool {
            var hash = Set<Character>()
            for c in 0 ..< COL {
                var currentNum = board[row][c]
                if currentNum == "." { continue }
                if hash.contains(currentNum) {
                    return false
                }
                hash.insert(currentNum)
            }
            return true
        }

        func isValidCol(_ col: Int) -> Bool {
            var hash = Set<Character>()
            for r in 0 ..< ROW {
                var currentNum = board[r][col]
                if currentNum == "." { continue }
                if hash.contains(currentNum) {
                    return false
                }
                hash.insert(currentNum)
            }
            return true
        }

        func isValidBox(_ row: Int, _ col: Int) -> Bool {

            var hash = Set<Character>()
            for i in row ..< row + 3 {
                for j in col ..< col + 3 {
                    var currentNum = board[i][j]
                    if currentNum == "." { continue }
                    if hash.contains(currentNum) {
                        return false
                    }
                    hash.insert(currentNum)
                }
            }
            return true
        } 

        for r in 0 ..< ROW {
            if !isValidRow(r) {
                return false
            }
        }
        for c in 0 ..< COL {
            if !isValidCol(c) {
                return false
            }
        }
        for r in stride(from: 0, to: ROW, by: 3) {
            for c in stride(from: 0, to: COL, by: 3) {
                if !isValidBox(r, c) {
                    return false
                }
            }
        }

        return true

    }
}
