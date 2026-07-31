class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        var maxHeap = PriorityQueue<Int>(Comparator<Int>() { c1, c2 -> 
            c2 - c1
        })
        var queue = LinkedList<Pair<Int, Int>>()
        var hash = HashMap<Char, Int>()
        for (task in tasks) {
            hash[task] = (hash[task] ?: 0) + 1
        }
        for ((task, times) in hash) {
            maxHeap.add(times)
        }
        var currentCycle = 0
        while (maxHeap.count() > 0 || queue.count() > 0) {
            currentCycle += 1
            if (maxHeap.count() == 0) {
                currentCycle = queue.first().second
            } else {
                val count = maxHeap.poll()!! - 1
                if (count != 0) {
                    queue.add(Pair(count, currentCycle + n))
                }
            }
            if (queue.count() > 0 && queue.first().second == currentCycle) {
                maxHeap.add(queue.removeFirst().first)
            }
        }
        return currentCycle
    }
}
