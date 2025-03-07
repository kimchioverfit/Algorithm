class Solution {
    fun secondHighest(s: String): Int {
        var maxDigit = -1
        var secondMaxDigit = -1

        for(i in s) {
            if(i in '0'..'9') {
                val digit = i - '0'

                if(maxDigit < digit) {
                    if(maxDigit != -1) {
                        secondMaxDigit = maxDigit
                    }

                    maxDigit = digit
                } else if(secondMaxDigit < digit && digit != maxDigit) {
                    secondMaxDigit = digit
                }
            }
        }

        return secondMaxDigit
    }
}