class MedianFinder {

    var maxHeap = Heap<Int>()
    var minHeap = Heap<Int>()

    func addNum(_ num: Int) {
        if maxHeap.count == 0 {
            maxHeap.insert(num)
            return
        }
        if maxHeap.count > minHeap.count {
            minHeap.insert(num)
        } else {
            maxHeap.insert(num)
        }
        if (maxHeap.max! > minHeap.min!) {
            let temp = maxHeap.popMax()!
            maxHeap.insert(minHeap.popMin()!)
            minHeap.insert(temp)
        }
    }

    func findMedian() -> Double {
        if maxHeap.count == minHeap.count {
            return Double(maxHeap.max! + minHeap.min!) / 2.0
        } else if maxHeap.count > minHeap.count {
            return Double(maxHeap.max!)
        } else {
            return Double(minHeap.min!)
        }
    }
}
