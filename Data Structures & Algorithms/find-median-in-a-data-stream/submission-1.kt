class MedianFinder {

    val comparator = Comparator<Int>() { c1, c2 -> 
        c2 - c1
    }
    var maxHeap = PriorityQueue<Int>(comparator)
    var minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (maxHeap.count() == 0) {
            maxHeap.add(num)
            return
        }
        if (minHeap.count() == 0) {
            if (num < maxHeap.peek()!!) {
                minHeap.add(maxHeap.poll()!!)
                maxHeap.add(num)
            } else {
                minHeap.add(num)
            }
            return
        }
        if (maxHeap.count() > minHeap.count()) {
            minHeap.add(num)
        } else {
            maxHeap.add(num)
        }
        if (maxHeap.peek()!! > minHeap.peek()!!) {
            val temp = maxHeap.poll()!!
            maxHeap.add(minHeap.poll()!!)
            minHeap.add(temp)
        }
    }

    fun findMedian(): Double {
        if (maxHeap.count() == minHeap.count()) {
            return (maxHeap.peek()!! + minHeap.peek()!!) / 2.0
        } else if (maxHeap.count() > minHeap.count()) {
            return maxHeap.peek()!!.toDouble()
        } else {
            return minHeap.peek()!!.toDouble()
        }
    }
}
