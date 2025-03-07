class Solution {
     fun validIPAddress(queryIP: String): String {
        var isIpV4 = false
        var isIpV6 = false

        if(queryIP.contains(".")) {
            isIpV4 = true
        } else if(queryIP.contains(":")) {
            isIpV6 = true
        } else {
            return "Neither"
        }

        val splitted = queryIP.split(if(isIpV4) "." else ":")

        if(isIpV4) {
            if(splitted.size != 4) return "Neither"

            splitted.forEach {
                val number = it.toIntOrNull()

                if((it.startsWith("0") && number != 0)
                    || number == null || number > 255)
                    return "Neither"

                if(number == 0 && it.length != 1)
                    return "Neither"
            }
        } else {
            if(splitted.size != 8) return "Neither"

            splitted.forEach {
                if(!(it.length in 1..4)) return "Neither"

                it.forEach { ch ->
                    if(!(ch in 'a'..'f' || ch in 'A'..'F' || ch in '0'..'9')) return "Neither"
                }
            }
        }

        return if(isIpV4) "IPv4"
        else if(isIpV6) "IPv6"
        else "Neither"
    }
}
