/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var comparator = Comparator<ListNode>() { c1, c2 -> 
            c1.`val` - c2.`val`
        }
        var minHeap = PriorityQueue<ListNode>(comparator)
        for (list in lists) {
            minHeap.add(list)
        }
        var head = ListNode(-1)
        var current: ListNode? = head
        while (minHeap.count() > 0) {
            var node = minHeap.poll()!!
            current?.next = ListNode(node.`val`)
            current = current?.next
            if (node.next != null) {
                minHeap.add(node.next)
            }
        }
        return head.next
    }
}
