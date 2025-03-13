class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        val set = mutableSetOf<Float>()

        for(num in arr) {
            if(set.contains(num / 2.0f) || set.contains(num * 2.0f)) {
                return true
            }

            set.add(num.toFloat())
        }

        return false
    }
}