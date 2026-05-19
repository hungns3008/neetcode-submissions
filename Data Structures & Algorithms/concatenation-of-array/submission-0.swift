class Solution {
    func getConcatenation(_ nums: [Int]) -> [Int] {

        var output = [Int]()

        for i in 0 ..< nums.count * 2 {
            output.append(nums[i % nums.count])
        }

        return output

    }
}
