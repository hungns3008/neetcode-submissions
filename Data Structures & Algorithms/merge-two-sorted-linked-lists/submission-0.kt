/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var output = ListNode(-1)
        var current: ListNode? = output

        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            val value1 = l1!!.`val`
            val value2 = l2!!.`val`
            if (value1 <= value2) {
                current?.next = ListNode(value1)
                l1 = l1?.next
            } else {
                current?.next = ListNode(value2)
                l2 = l2?.next
            }
            current = current?.next
        }

        if (l1 != null) {
            current?.next = l1
        }
        if (l2 != null) {
            current?.next = l2
        }

        return output.next
    }
}
