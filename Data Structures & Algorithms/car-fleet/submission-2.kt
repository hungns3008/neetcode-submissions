class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        var carInfo = mutableListOf<DoubleArray>()
        for (i in 0 until position.count()) {
            var time = (target - position[i]).toDouble() / speed[i].toDouble()
            carInfo.add(doubleArrayOf(position[i].toDouble(), speed[i].toDouble(), time))
        }
        carInfo.sortWith(Comparator<DoubleArray>() { c1, c2 -> 
            if (c1[0] > c2[0]) {
                1
            } else {
                -1
            }
        })
        var stack = LinkedList<DoubleArray>()
        stack.add(carInfo[carInfo.count() - 1])

        var output = position.count()
        
        for (i in carInfo.count() - 2 downTo 0) {
            if (carInfo[i][2] <= stack.first()!![2]) {
                output -= 1
            } else {
                stack.addFirst(carInfo[i])
            }
        }

        return output
    }
}
