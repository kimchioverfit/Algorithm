class Solution {
    fun timeToNumber(time: String) : Int {
        return time.substring(0, 2).toInt() * 60 + time.substring(3, 5).toInt()
    }

    fun haveConflict(event1: Array<String>, event2: Array<String>): Boolean {
        // 겹치는 경우

        val e1Start = timeToNumber(event1[0])
        val e1End = timeToNumber(event1[1])
        val e2Start = timeToNumber(event2[0])
        val e2End = timeToNumber(event2[1])

        return (e2Start in (e1Start..e1End)) || (e1Start in (e2Start..e2End))
        || (e2End in (e1Start..e1End)) || (e1End in (e2Start..e2End))
    }
}