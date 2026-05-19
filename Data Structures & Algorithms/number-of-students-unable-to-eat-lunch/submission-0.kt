class Solution {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {

        var res = students.size
        val cnt = IntArray(2)
        for (student in students) {
            cnt[student]++
        }

        for (s in sandwiches) {
            if (cnt[s] > 0) {
                cnt[s]--
                res--
            } else {
                break
            }
        }
        return res
    }
}