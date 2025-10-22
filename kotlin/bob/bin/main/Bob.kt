object Bob {
    fun hey(input: String): String {
        val trimmed = input.trim()

        val isSilence   = trimmed.isBlank()
        val isQuestion  = trimmed.endsWith("?")
        val hasLetters  = trimmed.any { it.isLetter() }
        val isYelling   = hasLetters && trimmed == trimmed.uppercase()

        return when {
            isSilence               -> "Fine. Be that way!"
            isYelling && isQuestion -> "Calm down, I know what I'm doing!"
            isQuestion              -> "Sure."
            isYelling               -> "Whoa, chill out!"
            else                    -> "Whatever."
        }
    }
}
