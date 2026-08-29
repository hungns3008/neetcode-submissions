class Solution {
    func solve(_ board: inout [[Character]]) {
        let directions = [
            [0, 1],
            [0, -1],
            [1, 0],
            [-1, 0]
        ]

        let ROW = board.count
        let COL = board[0].count

        func dfs(_ r: Int, _ c: Int, _ region: inout Set<[Int]>) -> Bool {
            if board[r][c] == "X" {
                return true
            }
            if r == 0 || r == ROW - 1 || c == 0 || c == COL - 1 {
                return false
            }

            region.insert([r, c])
            var isValid = true

            for direction in directions {
                let newX = r + direction[0]
                let newY = c + direction[1]
                if newX >= 0 && newX < ROW && newY >= 0 && newY < COL && !region.contains([newX, newY]) {
                    if !dfs(newX, newY, &region) {
                        isValid = false
                    }
                }
            }
            return isValid
        }

        for i in 0 ..< ROW {
            for j in 0 ..< COL {
                if board[i][j] == "O" {
                    var region = Set<[Int]>()
                    if dfs(i, j, &region) {
                        for cell in region {
                            board[cell[0]][cell[1]] = "X"
                        }
                    }
                }
            }
        }
    }
}
