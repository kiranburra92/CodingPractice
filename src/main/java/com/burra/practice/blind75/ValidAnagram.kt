package com.burra.practice.blind75

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length)
            return false
        val result = IntArray(26)

        for(i in s.indices){
           result[s[i]-'a']++
            result[t[i]-'a']--
        }
        result.forEach { if(it < 0) return false }
        return true
    }
}