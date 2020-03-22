package subtask5

import kotlin.math.max

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var count = 0
        val changeArray = mutableListOf<Int>()

        for (index in digitString.indices) {
            if (index >= n / 2) break

            val oppositeElement = digitString.elementAt(digitString.length - index - 1)
            if (digitString.elementAt(index) != oppositeElement) {
                count++
                changeArray.add(index)
            }
        }

        if (count > k) return "-1"

        val tmpString = digitString.toMutableList()
        for (index in changeArray) {
            val oppositeIndex = digitString.length - index - 1
            val max = max(tmpString.elementAt(index).toInt(), tmpString.elementAt(oppositeIndex).toInt()).toChar();
            tmpString[index] = max
            tmpString[oppositeIndex] = max
        }

        var extraK = k - count

        for (index in tmpString.indices) {
            if (extraK == 0) break
            if (tmpString.elementAt(index) == '9') continue

            val requiredK = if (changeArray.contains(index)) 1 else 2

            if (requiredK > extraK) continue

            val oppositeIndex = digitString.length - index - 1

            tmpString[index] = '9'
            tmpString[oppositeIndex] = '9'

            extraK -= requiredK;
        }

        return String(tmpString.toCharArray())
    }
}
