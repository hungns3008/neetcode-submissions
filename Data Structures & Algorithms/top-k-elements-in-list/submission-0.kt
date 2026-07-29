class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        var hash = HashMap<Int, Int>() // number: counter
        for (num in nums) {
            hash[num] = (hash[num] ?: 0) + 1
        }
        // IntArray => Number: Counter
        var priorityQueue = PriorityQueue<IntArray>(Comparator<IntArray>() { c1, c2 ->
            c2[1] - c1[1]
        })
        for ((number, counter) in hash) {
            priorityQueue.add(intArrayOf(number, counter))
        }
        var output = mutableListOf<Int>()
        var mK = k
        while (mK > 0) {
            output.add(priorityQueue.poll()!![0])
            mK -= 1
        }
        return output.toIntArray()
    }
}
