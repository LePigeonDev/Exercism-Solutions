object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        require(start > 0) {"[ERROR]: negative numbers"}

        var number : ULong = start.toULong()
        var count : Int = 0

        while (number != 1UL) {
            if(number % 2UL == 0UL) {
                number = number / 2UL
            } else {
                number = 3UL * number + 1UL;
            }
            count ++;
        }

        return count;
    }
}
