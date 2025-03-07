class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var left = arr.size / 2
        var right = left + 1

        var index = -1
        var peakValue = -1

        while(true) {
            if(left < 0 && right >= arr.size) break

            if(left >= 0) {
                if(peakValue < arr[left]) {
                    peakValue = arr[left]
                    index = left
                }

                left--
            }

            if(right < arr.size) {
                if(peakValue < arr[right]) {
                    peakValue = arr[right]
                    index = right
                }

                right++
            }
        }

        return index
    }
}
