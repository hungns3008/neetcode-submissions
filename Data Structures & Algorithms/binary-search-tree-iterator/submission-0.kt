
class BSTIterator(root: TreeNode?) {

    var arr = mutableListOf<Int>()
    var currentIndex = 0

    init {
        fun inorder(node: TreeNode?) {
            if (node == null) {
                return
            }
            inorder(node!!.left)
            arr.add(node!!.`val`)
            inorder(node!!.right)
        }        
        inorder(root)
    }

    fun next(): Int {
        if (currentIndex < arr.count()) {
            return arr[currentIndex++]
        }
        return -1
    }

    fun hasNext(): Boolean {
        return currentIndex < arr.count()
    }
}
