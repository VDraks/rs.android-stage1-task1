package subtask4

class StringParser {

    data class StringData(
        var indexInResult: Int = 0,
        var string: StringBuilder = java.lang.StringBuilder()
    )

    data class BracketsData(
        var openChar: Char,
        var closeChar: Char,
        var data: MutableList<StringData> = mutableListOf()
    )

    fun getResult(inputString: String): Array<String> {
        val result = mutableListOf<String>()
        val bracketsResult = arrayOf(
            BracketsData('[', ']'),
            BracketsData('<', '>'),
            BracketsData('(', ')')
        )

        for (symbol in inputString) {
            for (bracketsData in bracketsResult) {
                if (symbol == bracketsData.closeChar) {
                    if (bracketsData.data.isNotEmpty()) {
                        val data = bracketsData.data.last();
                        result.add(data.indexInResult, data.string.toString())
                        bracketsData.data.removeAt(bracketsData.data.lastIndex)
                    }
                }

                for (data in bracketsData.data) {
                    data.string.append(symbol)
                }

                if (symbol == bracketsData.openChar) {
                    bracketsData.data.add(StringData(result.lastIndex + 1));
                }
            }
        }

        return result.toTypedArray();
    }
}
