class Solution {
    func lastStoneWeight(_ stones: [Int]) -> Int {
        var maxHeap = Heap<Int>()
        for stone in stones {
            maxHeap.insert(stone)
        }
        while maxHeap.count > 1 {
            var stone1 = maxHeap.popMax()!
            var stone2 = maxHeap.popMax()!
            maxHeap.insert(abs(stone1 - stone2))
        }
        return maxHeap.max!
    }
}
