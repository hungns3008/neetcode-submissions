class TimeMap() {

    // key: [ [Value: TimeStamp], [Value: TimeStamp], [Value: TimeStamp] ]
    
    var hash = HashMap<String, MutableList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (hash[key] == null) {
            hash[key] = mutableListOf()
        }
        hash[key]!!.add(Pair(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        var output = ""
        var list = hash[key] ?: return output
        var left = 0
        var right = list.lastIndex

        while (left <= right) {
            var mid = (left + right) / 2
            if (list[mid].second <= timestamp) {
                output = list[mid].first
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return output
    }
}
