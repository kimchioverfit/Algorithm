class Solution {
    fun passThePillow(n: Int, _time: Int): Int {
        val time = _time % ((n - 1) * 2)

        return if(time > (n - 1)) {
            n - (time - (n - 1))
        } else {
            time + 1
        }
    }
}
