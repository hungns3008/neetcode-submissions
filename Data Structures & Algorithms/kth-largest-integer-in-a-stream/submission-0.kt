class KthLargest(k: Int, nums: IntArray) {

    var minHeap = PriorityQueue<Int>(Comparator<Int>() { c1, c2 -> 
        c1 - c2
    })

    var size = 0

    init {
        size = k
        for (num in nums) {
            minHeap.add(num)
            if (minHeap.count() > size) {
                minHeap.poll()
            }
        }
    }

    fun add(`val`: Int): Int {

        minHeap.add(`val`)
        if (minHeap.count() > size) {
            minHeap.poll()
        }

        return minHeap.peek()

    }
}
