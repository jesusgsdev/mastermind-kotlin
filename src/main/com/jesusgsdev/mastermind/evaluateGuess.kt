package jesusgsdev.mastermind

data class Evaluation(val positions: Int, val letters: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val positions = getGuessedInRightPositions(secret, guess)
    val letters = getGuessedInWrongPositions(secret, guess)

    return Evaluation(positions, letters)
}

private fun getGuessedInRightPositions(secret: String, guess: String): Int {
    var positions = 0
    for(i in 0 until secret.length) { //How many letter guessed
        if(secret[i] == guess[i]) { //Guessed right and in the right position
            positions ++
        }
    }
    return positions
}

private fun getGuessedInWrongPositions(secret: String, guess: String): Int {
    var letters = 0
    var newSecret = ""
    var newGuess = ""

    for(i in 0 until secret.length) {
        if(secret[i] != guess[i]) {
            newSecret += secret[i]
            newGuess += guess[i]
        }
    }

    val evaluatedChars = mutableListOf<Char>()
    if(!newSecret.isEmpty()) {
        for (i in 0 until guess.length) {
            val letter = guess[i]
            if (!evaluatedChars.contains(letter)) {
                val howManyInSecret = countHowMany(newSecret, letter)
                val howManyInGuess = countHowMany(newGuess, letter)
                letters += if (howManyInSecret == howManyInGuess || howManyInSecret > howManyInGuess) howManyInGuess
                                else howManyInSecret

                evaluatedChars.add(letter)
            }
        }
    }

    return letters
}

private fun countHowMany(letters: String, letter: Char): Int {
    var howMany = 0
    for (i in 0 until letters.length) {
        if (letters[i] == letter) {
            howMany++
        }
    }
    return howMany
}
