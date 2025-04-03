class Solution {
    fun getGcd(_num1: Int, _num2: Int): Int {
        var num1 = _num1
        var num2 = _num2

        while(num2 != 0){
		    val r = num1 % num2;
		    num1 = num2
		    num2 = r
	    }
	    return num1
    }
    
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var cur = head

        while(cur != null) {
            if(cur.next == null) break

            val next = cur.next

            val gcd = getGcd(cur.`val`, cur.next.`val`)
            val newNode = ListNode(gcd)

            cur.next = newNode
            newNode.next = next

            cur = next
        }

        return head
    }
}
