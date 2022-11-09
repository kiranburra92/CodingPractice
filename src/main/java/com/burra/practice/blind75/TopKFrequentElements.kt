package com.burra.practice.blind75

class TopKFrequentElements {
    /**
     * Bucket sort, or bin sort, is a sorting algorithm that works by distributing the elements of an array into a number of buckets. Each bucket is then sorted individually, either using a different sorting algorithm, or by recursively applying the bucket sorting algorithm.

    In this process we gonna follow 3 major steps :-

    Step - 1 :
    Create Frequency map:

    Step - 2 :
    Create Bucket List[]:

    Step - 3 :
    If we look at bucket arr we can see that most frequent elements are located at the end of arr
    and leat frequent elemnts at the begining
    Last step is to iterate from the end to the begining of the arr and add elements to result List
     */
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = HashMap<Int, Int>()
        nums.forEach { frequencyMap[it] = frequencyMap.getOrDefault(it, 0)+1 }

        val bucketList = Array(nums.size + 1) { i -> arrayListOf<Int>() }

        frequencyMap.forEach { entry -> bucketList[entry.value].add(entry.key) }

        var index = 0
        val result = IntArray(k)
        for(i in bucketList.size-1 downTo 0){
            if(bucketList[i].isNotEmpty()) {
                for (j in bucketList[i]) {
                    result[index] = j
                    index++
                    if (index == k)
                        return result
                }
            }
        }
        return result
    }
}

fun main() {
    var topKFrequentElements = TopKFrequentElements()
    var result =  topKFrequentElements.topKFrequent(intArrayOf(1,1,1,2,2,3),2)
    println(result)
}