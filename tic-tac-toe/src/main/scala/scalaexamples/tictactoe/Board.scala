package scalaexamples.tictactoe

abstract class Board protected(val boardState: Matrix[CellState]) {
 
  def newBoard(x: Int, y: Int, state: CellState) = {
    assert(boardState(x, y) == Empty)
    val newState = boardState.createCopyAndUpdateSlot(x, y, state)
    val res = createNewBoard(newState)
    res
  }
  
  def cols = boardState.cols
  def rows = boardState.rows
  
  protected def createNewBoard(boardState: Matrix[CellState]): Board
  
  def apply(x: Int, y: Int) = boardState(x,y)
  
  def showBoardState(): Unit

  def movePossible = boardState.emptySlots
}
