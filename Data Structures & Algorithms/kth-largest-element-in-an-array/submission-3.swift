class Solution {
    func findKthLargest(_ nums: [Int], _ k: Int) -> Int {

        var minHeap = Heap<Int>()

        for num in nums {
            minHeap.insert(num)
            if minHeap.count > k {
                var _ = minHeap.popMin()
            }
        }

        return minHeap.min!

    }
}
