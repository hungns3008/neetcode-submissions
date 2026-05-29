/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    
        fun reverse(node: ListNode?): ListNode? {
            if (node == null) {
                return null
            }
            var prev: ListNode? = null
            var current = node
            while (current != null) {
                var temp = current?.next
                current?.next = prev
                prev = current
                current = temp
            }            
            return prev
        }

    fun pairSum(head: ListNode?): Int {

        var slow = head
        var fast = head
        while (fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        var revNode = reverse(slow)
        var current = head

        var output = 0

        while (revNode != null) {
            output = maxOf(output, current!!.`val` + revNode!!.`val`)
            current = current?.next
            revNode = revNode?.next
        }
        return output

    }
}