class Solution {
    func islandsAndTreasure(_ grid: inout [[Int]]) {

        var queue = [(Int, Int)]() // treasture position
        let directions = [
            (0, 1),
            (0, -1),
            (1, 0),
            (-1, 0),
        ]

        for r in 0 ..< grid.count {
            for c in 0 ..< grid[0].count {
                if grid[r][c] == 0 {
                    queue.append((r, c))
                }
            }
        }

        while queue.count > 0 {
            let size = queue.count
            for _ in 0 ..< size {
                let (r, c) = queue.removeFirst()
                for direction in directions {
                    let newR = r + direction.0
                    let newC = c + direction.1
                    if newR >= 0 && newR < grid.count && newC >= 0 && newC < grid[0].count && grid[newR][newC] == Int32.max {
                        grid[newR][newC] = min(grid[newR][newC], 1 + grid[r][c])
                        queue.append((newR, newC))
                    }
                }
            }
        }

    }
}
