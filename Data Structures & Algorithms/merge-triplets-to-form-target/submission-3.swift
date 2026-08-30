class Solution {
    func mergeTriplets(_ triplets: [[Int]], _ target: [Int]) -> Bool {
        // remove all triples that has value greater than target triplet
        var new = [[Int]]()
        for t in triplets {
            if (t[0] > target[0]) {
                continue
            }
            if (t[1] > target[1]) {
                continue
            }
            if (t[2] > target[2]) {
                continue
            }
            new.append(t)
        }
        // all numbers in new row should be smaller or equal to values in target triplet
        var new1 = [[Int]]()
        for t in new {
            // select t only if it has 1 of its value equal to target
            if t[0] == target[0] || t[1] == target[1] || t[2] == target[2] {
                new1.append(t)
            } 
        }
        if new1.count == 0 {
            return false
        }
        while new1.count > 1 {
            var first = new1.removeLast()
            var second = new1.removeLast()
            new1.append(
                [
                    max(first[0], second[0]),
                    max(first[1], second[1]),
                    max(first[2], second[2])
                ]
            )
        }
        return new1[0][0] == target[0] && new1[0][1] == target[1] && new1[0][2] == target[2]
    }
}
