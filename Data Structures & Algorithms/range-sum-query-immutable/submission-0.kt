class NumArray(nums: IntArray) {

    var prefix = mutableListOf<Int>()

    init {
        var current = 0
        for (num in nums) {
            current += num
            prefix.add(current)
        }

        // 1 2 3 4
        // 1 3 6 10

        //  
    }

    fun sumRange(left: Int, right: Int): Int {
        if (left - 1 >= 0) {
            return prefix[right] - prefix[left - 1]
        }
        return prefix[right]
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */