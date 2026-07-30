class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        var stack = LinkedList<IntArray>()
        var output = IntArray(temperatures.count()) { 0 }
        stack.addFirst(intArrayOf(temperatures[temperatures.count() - 1], temperatures.count() - 1))
        for (i in temperatures.count() - 2 downTo 0) {
            var current = temperatures[i]
            while (stack.count() > 0 && current >= stack.first()[0]) {
                stack.removeFirst()
            }
            if (stack.count() != 0) {
                output[i] = stack.first()[1] - i
            }
            stack.addFirst(intArrayOf(current, i))
        }
        return output
    }
}