package com.burra.practice.blind75

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]


Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<String, MutableList<String>>()

        strs.forEach {
            val countsString = countOfCharacter(it)
            val temp = map.getOrDefault(countsString, mutableListOf())
            temp.add(it)
            map[countsString] = temp
        }

        return map.values.toList()
    }

    private fun countOfCharacter(it: String): String {
        val array = IntArray(26)
        it.forEach { array[it - 'a']++ }
        val sb = StringBuilder()
        array.forEach {
            sb.append(it)
            sb.append("#")
        }
        return sb.toString()
    }
}