class Solution {
    fun lastStoneWeight(stones: IntArray): Int {

        var maxHeap = PriorityQueue<Int>(Comparator<Int>() { c1, c2 ->
            c2 - c1
        })

        for (stone in stones) {
            maxHeap.add(stone)
        }

        while (maxHeap.count() > 1) {
            var s1 = maxHeap.poll()
            var s2 = maxHeap.poll()
            maxHeap.add(Math.abs(s1 - s2))
        }

        return maxHeap.peek() ?: 0

    }
}
