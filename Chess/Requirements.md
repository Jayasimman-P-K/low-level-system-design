### Problem Statements: Chess LLD

We have to design simple chess game.

#### Entities

If you have already played it already then you might already know this. But to ensure that we all are on the same page, I am defining some here:

- Board: Board is the one entity represents an actual board on which which you play this game.
- Cell: A board consists of a grid of cells.
- Player: Someone who is actually playing right.
- Piece: There are various types of pieces as explained below.

#### Pieces and their moves:

- King: Key entity in chess. If your king is killed then you lose. Its also called checkmate.
- Queen: It can move any number of steps in a single move and in any direction.
- Rook: It only moves in horizontal and vertical direction but can move any number of steps in single move.
- Bishop: It only moves in diagonal direction but can move any number of steps in single move.
- Knight: It makes L shaped moves. Check online for more details about it.
- Pawn: It can move 1 step forward vertically. If it is its first turn, then it can also choose to make 2 steps in single move.  
  Note: All pieces except Knight cannot jump any other piece. Knight can jump over other pieces.

#### Technical Expectations

- Code should be functionally correct.
- Code should be modular and readable. Clean and professional level code.
- Code should be extesible and scalable. Means it should be able to accomodate new requirements with minimal changes.
- Code should have good OOPs design.

#### Good to Add

- Pawns should be converted into Queen if they reach the last row.
- Stalemate should be handled.
- Chequemate should result in winning the game.
- Castling can be handled as extension to this problem.

### Folder Structure:

```css
src
├── TicTacToe
│   ├── Models
│   │   ├── Board.java
│   │   ├── Player.java
│   ├── Enum
│   │   └── GameStatus.java
│   ├── Services
│   │   └── Game.java
│   └── Driver.java

```
