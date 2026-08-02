class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.count() % groupSize != 0) return false
        var treeMap = TreeMap<Int, Int>()
        for (h in hand) {
            treeMap[h] = (treeMap[h] ?: 0) + 1
        }

        while (treeMap.count() > 0) {
            val card = treeMap.firstKey()
            val numOfCard = treeMap[card]!!
            for (k in 0 until groupSize) {
                val c = card + k
                val cnt = treeMap[c] ?: return false
                if (cnt < numOfCard) return false
                if (cnt == numOfCard) treeMap.remove(c) else treeMap[c] = cnt - numOfCard
            }
        }
        return true
    }
}
