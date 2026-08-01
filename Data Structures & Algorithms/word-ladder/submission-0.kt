class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        if (!wordList.contains(endWord) || beginWord == endWord) {
            return 0
        }

        var words = wordList.toMutableSet()
        var res = 0
        var queue = LinkedList<String>()
        queue.add(beginWord)

        while (queue.count() > 0) {
            var size = queue.count()
            res += 1
            for (i in 0 until size) {
                var currentWord = queue.removeFirst()
                if (currentWord == endWord) {
                    return res
                }
                for (j in 0 until currentWord.count()) {
                    for (k in 'a'..'z') {
                        if (currentWord[j] == k) {
                            continue
                        }
                        var replacedWord = currentWord.substring(0, j) + k + currentWord.substring( j + 1)
                        if (words.contains(replacedWord)) {
                            words.remove(replacedWord)
                            queue.add(replacedWord)
                        }
                    }
                }
            }
        }

        return 0

    }
}
