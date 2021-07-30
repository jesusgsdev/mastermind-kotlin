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
                val howManyInSecret = newSecret.count{ c -> c == letter } 
                val howManyInGuess = newGuess.count{ c -> c == letter }
                letters += if (howManyInSecret >= howManyInGuess) howManyInGuess else howManyInSecret
                evaluatedChars.add(letter)
            }
        }
    }

    return letters
}
