package subtask3

class BillCounter {

    private val fairlySplit = "bon appetit"

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val annaValue = bill.filterIndexed { index, _ -> index != k }.sum() / 2;
        return if (annaValue == b) fairlySplit
        else (b - annaValue).toString()
    }
}
