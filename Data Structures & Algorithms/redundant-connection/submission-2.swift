class Solution {
    func findRedundantConnection(_ edges: [[Int]]) -> [Int] {
        var rank = Array(repeating: 0, count: edges.count + 1)
        var par = Array(repeating: 0, count: edges.count + 1)
        
        for i in 1 ... edges.count {
            par[i] = i
        }

        func find(_ n: Int) -> Int {
            if n != par[n] {
                par[n] = find(par[n])
            }
            return par[n]
        }

        func union(_ n1: Int, _ n2: Int) -> Bool {
            let p1 = find(n1)
            let p2 = find(n2)
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

        for edge in edges {
            if !union(edge[0], edge[1]) {
                return edge
            }
        }
        return []
    }
}
