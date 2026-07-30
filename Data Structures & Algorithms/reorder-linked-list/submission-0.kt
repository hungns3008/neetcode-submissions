/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {

        fun reverse(node: ListNode?): ListNode? {
            var prev: ListNode? = null
            var current = node
            while (current != null) {
                var next = current?.next
                current?.next = prev
                prev = current
                current = next
            }
            return prev
        }

        var slow = head
        var fast = head
        while (fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var leftNode = head
        var rightNode = reverse(slow)

        while (leftNode?.next != rightNode) {
            var l1 = leftNode?.next
            var l2 = rightNode?.next
            leftNode?.next = rightNode
            rightNode?.next = l1

            leftNode = l1
            rightNode = l2
        }
        
    }
}
