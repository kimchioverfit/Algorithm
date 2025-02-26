class Solution {
    var numbers = LinkedList<Int>()

    fun traversal(head: ListNode?) {
        if(head == null) return

        numbers.addFirst(head.`val`)
        traversal(head.next)
    }

    fun doubleIt(head: ListNode?): ListNode? {
        traversal(head)

        var newHead = ListNode((numbers[0] * 2) % 10)
        var left = numbers[0] * 2 / 10
        
        for(i in 1 until numbers.size) {
            val number = numbers[i] * 2 + left

            val node = ListNode(number % 10)
            
            left = number / 10

            node.next = newHead
            newHead = node
        }

        if(left != 0) {
            val node = ListNode(left)

            node.next = newHead
            newHead = node
        }

        return newHead
    }
}
