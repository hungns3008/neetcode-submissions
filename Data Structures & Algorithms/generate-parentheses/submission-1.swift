class Solution {
    func generateParenthesis(_ n: Int) -> [String] {
        
        var output = [String]()

        func dfs(_ o: Int, _ c: Int, _ current: String) {

            if o == n && c == n {
                output.append(current)
                return
            }

            if o > n || c > n {
                return
            }

            if o < c {
                return
            }
            
            var new = current + "("
            dfs(o + 1, c, new)

            new = current + ")"
            dfs(o, c + 1, new)

        }

        dfs(0, 0, "")

        return output

    }
}
