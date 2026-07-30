/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2
        var output = ListNode(-1)
        var current: ListNode? = output

        var leftOver = 0
        while (node1 != null && node2 != null) {
            var val1 = node1!!.`val`
            var val2 = node2!!.`val`
            var sum = val1 + val2 + leftOver
            var remaining = sum % 10
            leftOver = sum / 10
            val newNode = ListNode(remaining)
            current?.next = newNode
            current = current?.next
            node1 = node1?.next
            node2 = node2?.next
        }
        while (node1 != null) {
            val sum = node1!!.`val` + leftOver
            var remaining = sum % 10
            leftOver = sum / 10
            val newNode = ListNode(remaining)
            current?.next = newNode
            current = current?.next
            node1 = node1?.next
        }
        while (node2 != null) {
            val sum = node2!!.`val` + leftOver
            var remaining = sum % 10
            leftOver = sum / 10
            val newNode = ListNode(remaining)
            current?.next = newNode
            current = current?.next
            node2 = node2?.next
        }
        if (leftOver != 0) {
            val newNode = ListNode(leftOver)
            current?.next = newNode
        }
        return output.next
    }
}
