class Solution {
    func countComponents(_ n: Int, _ edges: [[Int]]) -> Int {
        var rank = Array(repeating: 0, count: n)
        var par = Array(repeating: 0, count: n)
        
        for i in 0 ..< n {
            par[i] = i
        }

        func find(_ n: Int) -> Int {
            if n != par[n] {
                par[n] = find(par[n])
            }
            return par[n]
        }

        func union(_ n1: Int, _ n2: Int) -> Bool {
            var p1 = find(n1)
            var p2 = find(n2)
            if p1 == p2 {
                return false
            }
            if rank[p1] >= rank[p2] {
                par[p2] = p1
                rank[p1] += 1
            } else {
                par[p1] = p2
                rank[p2] += 1 
            }
            return true
        }

        var output = n

        for edge in edges {
            if union(edge[0], edge[1]) {
                output -= 1
            }
        }
        return output
    }
}
