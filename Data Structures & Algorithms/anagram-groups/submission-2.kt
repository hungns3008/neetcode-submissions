class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        fun getKey(str: String): String {
            var arr = IntArray(28) { 0 }
            for (ch in str) {
                arr[ch.toInt() - 'a'.toInt()] += 1
            }
            var output = StringBuilder()
            for (i in 0 until arr.count()) {
                if (arr[i] > 0) {
                    output.append("${i.toChar()}${arr[i]}-")
                }
            }
            return output.toString()
        }

        var hash = HashMap<String, MutableList<String>>()
        for (str in strs) {
            var key = getKey(str)
            if (hash[key] == null) {
                hash[key] = mutableListOf()
            }
            hash[key]!!.add(str)
        }

        var output = mutableListOf<MutableList<String>>()
        for ((key, value) in hash) {
            output.add(value)
        }

        return output

    }
}
