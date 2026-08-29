class Solution {
    func orangesRotting(_ grid: [[Int]]) -> Int {

        var grid = grid
        var queue = Deque<(Int, Int)>()
        var fresh = 0
        var time = 0

        let ROWS = grid.count
        let COLS = grid[0].count

        for r in 0..<ROWS {
            for c in 0..<COLS {
                if grid[r][c] == 1 {
                    fresh += 1
                }
                if grid[r][c] == 2 {
                    queue.append((r, c))
                }
            }
        }

        let directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        while fresh > 0 && !queue.isEmpty {
            let length = queue.count
            for _ in 0..<length {
                let (r, c) = queue.popFirst()!

                for dir in directions {
                    let row = r + dir[0]
                    let col = c + dir[1]

                    if row >= 0 && row < ROWS && col >= 0 && col < COLS && grid[row][col] == 1 {
                        grid[row][col] = 2
                        queue.append((row, col))
                        fresh -= 1
                    }
                }
            }
            time += 1
        }

        return fresh == 0 ? time : -1

    }
}
