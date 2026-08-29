class KthLargest {

    var heap = Heap<Int>() // min heap
    var size = 0

    init(_ k: Int, _ nums: [Int]) {
        self.size = k
        for num in nums {
            heap.insert(num)
            if heap.count > k {
                var _ = heap.popMin()
            }
        }
    }

    func add(_ val: Int) -> Int {
        heap.insert(val)
        if heap.count > size {
            var _ = heap.popMin()
        }
        return heap.min!
    }
}
