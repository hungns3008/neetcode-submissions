class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var map = [Int: Int]()
        for i in 0 ..< nums.count {
            if let index = map[nums[i]] {
                if i < index {
                    return [i , index]
                } else {
                    return [index, i]
                }
            }
            map[target - nums[i]] = i
        }
        return []
    }
}
