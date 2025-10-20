object Bob {
    fun hey(input: String): String {
        val contains : Boolean = input.contains('?');
        val upperCase : Boolean = input == input.uppercase();
        val containsAndUpperCase : Boolean = contains && upperCase;
        val whiteSpace : Boolean = input.isBlank();

        val answer = when {
            contains -> "sure"
            upperCase -> "Whoa, chill out!"
            containsAndUpperCase -> "Calm down, I know what I'm doing!"
            whiteSpace -> "Fine. Be that way!"
            else -> "Whatever."
        }
        return answer.toString();
    }
}
