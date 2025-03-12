class Solution {
    fun modifyString(s: String): String {
        if(s == "?") return "a"

        val sb = StringBuilder()

        for(i in 0 until s.length) {
            if(s[i] == '?') {
                if(i == 0) {
                    // 처음이 ? 일때
                    if(s[i + 1] == '?') {
                        sb.append('a')
                    } else {
                        sb.append(if(s[i + 1] != 'a') 'a' else 'b')
                    }
                } else if(i == (s.length - 1)) {
                    // 마지막이 ? 일때
                    sb.append(if(sb[i - 1] != 'a') 'a' else 'b')
                } else {
                    // 중간에 ?가 나오는 경우
                    // [i - 1]이 ?가 아니라는 것은 보장되어 있음
                    if(sb[i - 1] != 'a' && s[i + 1] != 'a') {
                        sb.append('a')
                    } else if(sb[i - 1] == 'a') {
                        sb.append(if(s[i + 1] == 'b') 'c' else 'b')
                    } else if(s[i + 1] == 'a') {
                        sb.append(if(sb[i - 1] == 'b') 'c' else 'b')
                    } else {
                        sb.append('a')
                    }
                }
            } else sb.append(s[i])
        }

        return sb.toString()
    }
}
