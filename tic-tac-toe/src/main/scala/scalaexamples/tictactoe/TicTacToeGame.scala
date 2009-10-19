package scalaexamples.tictactoe

object TicTacToeGame {

  def main(args: Array[String]) {
    val game = new console.ConsoleGame
    game.printWelcomeMessage
    
    val (rows, cols) = game.getBoardSize
    var board: Board = game.createBoard(rows, cols)

    val playerList = game.createHumanPlayer :: game.createComputerPlayer :: Nil
    
    var player = 0
    while(board.movePossible) {
      board.showBoardState()
      val current = playerList(player)
      game.alertNextPlayer(current)
      val (row, column) = current.move(board)
      board = board.newBoard(row, column, current.character)
      player = 1 - player 
    }
  }
  
}
