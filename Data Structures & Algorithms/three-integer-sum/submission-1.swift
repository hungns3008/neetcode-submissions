class Solution {
    func threeSum(_ nums: [Int]) -> [[Int]] {
        let sorted = nums.sorted()
        var output = [[Int]]()
        for i in 0 ..< sorted.count {
            if i > 0 && sorted[i] == sorted[i - 1] { continue }
            let target = 0 - sorted[i]
            var left = i + 1
            var right = sorted.count - 1
            while left < right {
                let sum = sorted[left] + sorted[right]
                if sum == target {
                    output.append([sorted[i], sorted[left], sorted[right]])
                    while left + 1 < right && sorted[left] == sorted[left + 1] {
                        left += 1
                    }
                    left += 1
                    right -= 1
                } else if sum > target {
                    right -= 1
                } else {
                    left += 1
                }
            }
        }
        return output
    }
}
