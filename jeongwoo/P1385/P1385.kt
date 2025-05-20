class Solution {
    fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        var answer = 0

        for(i in arr1) {
            var isDistanceValue = true
            for(j in arr2) {
                val diff = abs(i - j)

                if(diff <= d) isDistanceValue = false
            }

            if(isDistanceValue) answer++
        }

        return answer
    }
}
