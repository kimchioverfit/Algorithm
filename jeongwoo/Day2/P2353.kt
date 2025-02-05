class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
    // cuisine 별로 점수를 저장할 맵
    val ratingMap = mutableMapOf<String, PriorityQueue<Pair<String, Int>>>()
    // food가 어떤 cuisine에 속하는지 저장할 맵
    val cuisineMap = mutableMapOf<String, String>()

    init {
        for (i in foods.indices) {
            val food = foods[i]
            val cuisine = cuisines[i]
            val rating = ratings[i]

            if (ratingMap[cuisine].isNullOrEmpty()) {
                // rating 오름차순, rating이 같다면 food가 사전 빠른순
                ratingMap[cuisine] = PriorityQueue<Pair<String, Int>> { a, b ->
                    if (a.second == b.second) {
                        if (a.first > b.first) 1
                        else -1
                    } else {
                        b.second - a.second
                    }
                }

                ratingMap[cuisine]!!.add(Pair(food, rating))
            } else {
                ratingMap[cuisine]!!.add(Pair(food, rating))
            }

            cuisineMap[food] = cuisine
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val cuisine = cuisineMap[food] ?: return

        val targetFood = ratingMap[cuisine]?.find { it.first == food }
        ratingMap[cuisine]?.remove(targetFood)

        ratingMap[cuisine]?.add(Pair(food, newRating))
    }

    fun highestRated(cuisine: String): String {
        return ratingMap[cuisine]?.peek()?.first ?: ""
    }
}
