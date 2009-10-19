package scalaexamples.tictactoe.console

class ConsoleBoard(board: Matrix[CellState]) extends Board(board) {
  
  def createNewBoard(boardState: Matrix[CellState]) = new ConsoleBoard(boardState)
  
  def this(rows: Int, cols: Int) = this(Matrix[CellState](rows, cols, Empty))

  def this() = this(3,3)
  
  def showBoardState {
    println(toString)
  }
  
  override def toString = {
    val res = new StringBuilder
    for (y <- 0 to rows - 1) {
      if (y > 0) {
        res.append("---+" * (cols-1)).append("---\n")
      }
      for (x <- 0 to cols - 1) {
        if (x > 0) res.append("|")
        val cell = boardState(x, y)
        res.append(' ').append(cell).append(' ')
      }
      res.append('\n')
    }
    res.toString
  }

}
