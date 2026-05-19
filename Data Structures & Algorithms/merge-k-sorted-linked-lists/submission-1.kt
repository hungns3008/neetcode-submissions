/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        
        fun mergeNode(node1: ListNode?, node2: ListNode?): ListNode? {
            var head = ListNode(-1)
            var current: ListNode? = head
            var n1 = node1
            var n2 = node2
            while (n1 != null && n2 != null) {
                if (n1!!.`val` <= n2!!.`val`) {
                    current?.next = ListNode(n1!!.`val`)
                    n1 = n1?.next
                } else {
                    current?.next = ListNode(n2!!.`val`)
                    n2 = n2?.next
                }
                current = current?.next
            }
            if (n1 != null) {
                current?.next = n1
            }
            if (n2 != null) {
                current?.next = n2
            }

            return head.next
        }

        var mLists = mutableListOf<ListNode?>()
        for (node in lists) {
            mLists.add(node)
        }

        while (mLists.count() > 1) {
            var temp = mutableListOf<ListNode?>()
            var currentIndex = 0

            while (currentIndex < mLists.count()) {
                var node1 = mLists[currentIndex]
                var node2 = if (currentIndex + 1 < mLists.count()) mLists[currentIndex + 1] else null
                temp.add(mergeNode(node1, node2))
                currentIndex += 2
            }
            mLists = temp
        }
        if (mLists.count() == 0) {
            return null
        }
        return mLists[0]

    }
}
