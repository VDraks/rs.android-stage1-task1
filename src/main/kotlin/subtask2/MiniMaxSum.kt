package subtask2

class MiniMaxSum {

    private fun sumWithExcept(input: IntArray, forExclude: Int): Int {
        val excludeIndex = input.lastIndexOf(forExclude)
        return input.filterIndexed { index, _ -> index != excludeIndex }.sum()
    }

    fun getResult(input: IntArray): IntArray {
        return intArrayOf(sumWithExcept(input, input.max()!!), sumWithExcept(input, input.min()!!))
    }
}
