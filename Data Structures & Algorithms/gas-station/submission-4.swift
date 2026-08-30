class Solution {
    func canCompleteCircuit(_ gas: [Int], _ cost: [Int]) -> Int {

        var gasSum = 0
        var costSum = 0

        for g in gas {
            gasSum += g
        }

        for c in cost {
            costSum += c
        }

        if gasSum < costSum {
            return -1
        }

        var total = 0
        var output = 0

        for i in 0 ..< gas.count {
            total += gas[i] - cost[i]
            if total < 0 {
                total = 0
                output = i + 1
            }
        }

        return output
    }
}
