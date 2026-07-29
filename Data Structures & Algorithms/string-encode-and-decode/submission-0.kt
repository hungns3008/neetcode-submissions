class Solution {

    fun encode(strs: List<String>): String {
        var output = StringBuilder()
        for (str in strs) {
            var length = str.count()
            output.append("${length}@")
            output.append(str)
        }
        return output.toString()
    }

    // Hello World
    // 5@Hello5@World

    fun decode(str: String): List<String> {
        var i = 0
        var output = mutableListOf<String>()
        while (i < str.count()) {
            var sb = ""
            while (str[i] != '@') {
                sb += "${str[i]}"
                i += 1
            }
            var numOfChar = sb.toString().toInt()
            var startingIndex = i + 1
            var endingIndex = startingIndex + numOfChar
            var currentWord = ""
            for (j in startingIndex until endingIndex) {
                currentWord += "${str[j]}"
            }
            output.add(currentWord)
            i = endingIndex
        }
        return output
    }
}
