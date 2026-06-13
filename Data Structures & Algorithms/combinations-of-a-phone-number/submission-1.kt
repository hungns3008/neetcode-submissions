class Solution {
    fun letterCombinations(digits: String): List<String> {

        var hash = HashMap<Char, String>()
        hash['2'] = "abc"
        hash['3'] = "def"
        hash['4'] = "ghi"
        hash['5'] = "jkl"
        hash['6'] = "mno"
        hash['7'] = "pqrs"
        hash['8'] = "tuv"
        hash['9'] = "wxyz"
        
        var output = mutableListOf<String>()
        var sb = StringBuilder()

        fun backtrack(i: Int) {
            if (i >= digits.count()) {
                if (sb.length > 0) output.add(sb.toString())
                return
            }
            hash[digits[i]]?.let { charData ->
                for (j in 0 until charData.count()) {
                    sb.append(charData[j])
                    backtrack(i + 1)
                    sb.deleteCharAt(sb.length - 1)
                }
            }
        }

        backtrack(0)

        return output

    }
}
