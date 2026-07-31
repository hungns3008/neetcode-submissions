class Twitter {

    var currentTimeStamp = 0
    var follow = HashMap<Int, HashSet<Int>>()    // userId: [followerID]
    var tweet = HashMap<Int, MutableList<IntArray>>() // userId: [tweetId]

    fun postTweet(userId: Int, tweetId: Int) {
        if (tweet[userId] == null) {
            tweet[userId] = mutableListOf()
        }
        tweet[userId]!!.add(intArrayOf(currentTimeStamp, tweetId))
        currentTimeStamp += 1
    }

    fun getNewsFeed(userId: Int): List<Int> {
        var output = mutableListOf<Int>()

        val maxHeap = PriorityQueue<IntArray>(Comparator<IntArray>() { c1, c2 ->
            c2[0] - c1[0]
        })

        if (follow[userId] == null) {
            follow[userId] = HashSet()
        }
        follow[userId]!!.add(userId)

        var followers = follow[userId]!!

        for (follower in followers) {
            var followerTweets = tweet[follower] ?: listOf()
            for (t in followerTweets) {
                val time = t[0]
                val tId = t[1]
                maxHeap.add(intArrayOf(time, tId))
            }
        }

        while (maxHeap.count() > 0 && output.count() < 10) {
            var recentTweet = maxHeap.poll()
            output.add(recentTweet[1])
        }

        return output
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (follow[followerId] == null) {
            follow[followerId] = HashSet()
        }
        follow[followerId]!!.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        follow[followerId]?.remove(followeeId)
    }
}
