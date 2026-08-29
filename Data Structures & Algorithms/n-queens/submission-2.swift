class Solution {
    func solveNQueens(_ n: Int) -> [[String]] {

        var board = Array(repeating: Array(repeating: ".", count: n), count: n)

        var output = [[String]]()

        var posDia = Set<Int>()
        var nevDia = Set<Int>()
        var col = Set<Int>()

        func backtrack(_ r: Int) {

            if r == n {
                var temp = [String]()
                for r in 0 ..< board.count {
                    var rowOutput = board[r].joined()
                    temp.append(rowOutput)
                }
                output.append(temp)
                return
            }

            for c in 0 ..< n {
                if !posDia.contains(r + c) && !nevDia.contains(r - c) && !col.contains(c) {
                    board[r][c] = "Q"
                    posDia.insert(r + c)
                    nevDia.insert(r - c)
                    col.insert(c)
                    backtrack(r + 1)

                    board[r][c] = "."
                    posDia.remove(r + c)
                    nevDia.remove(r - c)
                    col.remove(c)
                }
            }

        }

        backtrack(0)

        return output

    }
}
