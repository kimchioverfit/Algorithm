class Solution {
    fun isSameAfterReversals(num: Int): Boolean {
        return !(num % 10 == 0 && num != 0)
    }
}
