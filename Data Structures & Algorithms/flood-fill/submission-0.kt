class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        var directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
        )
        var stack = mutableListOf<IntArray>()
        var visited = mutableSetOf<String>()
        stack.add(intArrayOf(sr, sc))
        visited.add("${sr}-${sc}")

        while (stack.count() > 0) {
            var pixel = stack.removeFirst()!!
            var r = pixel[0]
            var c = pixel[1]
            var prevColor = image[r][c]
            image[r][c] = color
            
            for (direction in directions) {
                var nR = r + direction[0]
                var nC = c + direction[1]
                if (nR >= 0 && nR < image.count() && nC >= 0 && nC < image[0].count() && image[nR][nC] == prevColor && !visited.contains("${nR}-${nC}")) {
                    stack.add(intArrayOf(nR, nC))
                    visited.add("${nR}-${nC}")
                }
            }
        }

        return image

    }
}
