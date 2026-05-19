class Solution {
    func maxSlidingWindow(_ nums: [Int], _ k: Int) -> [Int] {
        var dequeue = [Int]()
        var left = 0
        var right = 0
        var output = [Int]()
        while right < nums.count {
            while dequeue.count > 0 && dequeue.last! < nums[right] {
                dequeue.removeLast()
            }
            dequeue.append(nums[right])
            if right - left + 1 == k {
                output.append(dequeue[0])
                if nums[left] == dequeue.first! {
                    dequeue.removeFirst()
                }
                left += 1
            }
            right += 1
        }
        return output
    }
}
