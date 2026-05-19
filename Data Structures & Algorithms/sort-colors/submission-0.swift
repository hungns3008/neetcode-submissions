class Solution {
    func sortColors(_ nums: inout [Int]) {
        var red = 0
        var white = 0
        var blue = 0

        for num in nums {
            if num == 0 {
                red += 1
            } else if num == 1 {
                white += 1
            } else {
                blue += 1
            }
        }
        var currentIndex = 0
        while red > 0 {
            nums[currentIndex] = 0
            currentIndex += 1
            red -= 1
        }
        while white > 0 {
            nums[currentIndex] = 1
            currentIndex += 1
            white -= 1
        }
        while blue > 0 {
            nums[currentIndex] = 2
            currentIndex += 1
            blue -= 1
        }
    }
}
