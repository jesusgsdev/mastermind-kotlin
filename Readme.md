### Mastermind game

Mastermind is a board game. The first player invents a code consisting of 4 balls of six different colors and the second player tries to break it. For task simplicity, we'll use letters from A to F instead of colors. Note that the letters might be repeated in the code.

The second player makes consecutive attempts to guess the code: he suggests the new combination of letters on each try until his guess is correct. The first player evaluates each combination by comparing it to her secret, and says how many letters are guessed correctly. First, she says the number of letters which are guessed with their positions, then the number of remaining letters which are guessed right but stay on the wrong positions.

Your task is to evaluate a guess in comparison to a given secret code.

- Example 1 (Different letters)

    Secret ABCD and guess ABCD must be evaluated to: positions = 4, letters = 0. All letters are guessed correctly in respect to their positions.

- Example 2 (Different letters)

    Secret ABCD and guess CDBA must be evaluated to: positions = 0, letters = 4. All letters are guessed correctly, but none has the right position.

- Example 3 (Different letters)

    Secret ABCD and guess ABDC must be evaluated to: positions = 2, letters = 2. A and B letters and their positions are guessed correctly. C and D letters are guessed correctly, but their positions are wrong.

- Example 4 (Repeated letters)

    Secret AABC and guess ADFE must be evaluated to: positions = 1, letters = 0. A at the first position is guessed correctly with its position. If we remove the first A from consideration (comparing the remaining ABC and DFE only), that will give us no more common letters or positions.