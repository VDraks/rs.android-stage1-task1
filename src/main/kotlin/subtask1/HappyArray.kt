package subtask1

class HappyArray {

    private fun checkLast(targetArray: MutableList<Int>, next: Int): MutableList<Int> = when {
        targetArray.size == 1 -> {
            targetArray
        }
        targetArray[targetArray.lastIndex - 1] + next >= targetArray.last() -> {
            targetArray;
        }
        else -> {
            targetArray.removeAt(targetArray.lastIndex);
            checkLast(targetArray, next);
        }
    }

    fun convertToHappy(sadArray: IntArray): IntArray {
        var result = emptyList<Int>().toMutableList();

        for (index in sadArray.indices) {
            if (index == 0 || index == sadArray.size - 1) {
                result.plusAssign(sadArray[index])
            } else if (result.last() + sadArray[index + 1] >= sadArray[index]) {
                result.plusAssign(sadArray[index]);
            } else {
                result = checkLast(result, sadArray[index + 1])
            }
        }
        println(result);
        return result.toIntArray();
    }
}
