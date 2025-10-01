### Problem: Design Tic-Tac-Toe

Assume the following rules are for a Tic-Tac-Toe game on an `n x n` board between two players:

1.  A move is guaranteed to be valid and is placed on an empty block.
2.  Once a winning condition is reached, no more moves will be made.
3.  A player who succeeds in placing `n` of their marks in a horizontal, vertical, or diagonal row wins the game.

Implement the `TicTacToe` class:

* `TicTacToe(int n)` Initializes the object of size `n`.
* `int move(int row, int col, int player)` Makes a move at `(row, col)` for a specific `player` (either `1` or `2`) and returns the winner's player number if the move results in a win. If no one wins, it returns `0`.

The main challenge is to design the `move` function to be as efficient as possible. A simple approach of checking the entire board after every move is too slow, especially for a large `n`. You should aim for a solution with a time complexity of $O(1)$ for each move.

-----

### Example

Here's an example of how the class should work for a `3x3` board:

```python
# Initialize a 3x3 Tic-Tac-Toe board.
ticTacToe = TicTacToe(3)

# Let's follow a sequence of moves.
# Player 1 moves to (0, 0)
ticTacToe.move(0, 0, 1)  # Returns 0 (no winner yet)

# Player 2 moves to (0, 2)
ticTacToe.move(0, 2, 2)  # Returns 0 (no winner yet)

# Player 1 moves to (2, 2)
ticTacToe.move(2, 2, 1)  # Returns 0 (no winner yet)

# Player 2 moves to (1, 1)
ticTacToe.move(1, 1, 2)  # Returns 0 (no winner yet)

# Player 1 moves to (2, 0)
ticTacToe.move(2, 0, 1)  # Returns 0 (no winner yet)

# Player 2 moves to (1, 0)
ticTacToe.move(1, 0, 2)  # Returns 0 (no winner yet)

# Player 1 moves to (2, 1)
ticTacToe.move(2, 1, 1)  # Returns 1. Player 1 wins!
```

The board state at the end would look like this, with Player 1 winning on the bottom row:

| P1 |    | P2 |
|----|----|----|
| P2 | P2 |    |
| P1 | P1 | P1 |

-----

### Constraints

* `2 <= n <= 100`
* `player` is either `1` or `2`.
* `0 <= row, col < n`
* All calls to `move` are valid.
* At most `n * n` calls will be made to `move`.