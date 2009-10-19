package scalaexamples.tictactoe

class Matrix[T] private(val contents: List[T], defaultValue: T, val rows: Int, val cols: Int) {

  def apply(x: Int, y: Int) = contents(getPos(x,y))
  private def getPos(x: Int, y: Int) = x + y * cols
  def emptySlots = contents.find(_ == defaultValue).isDefined
  
  def createCopyAndUpdateSlot(x: Int, y: Int, value: T) = {
    val position = getPos(x, y)
    
    def copyAndReplace(current: Int, theRest: List[T]): List[T] = {
      if(current == position) {
        value :: theRest
      }
      else {
        theRest.head :: copyAndReplace(current + 1, theRest.tail)
      }
    }
    val newList = copyAndReplace(0, contents)
    new Matrix(newList, defaultValue, rows, cols)
  }
}

object Matrix {
  
  private def buildInitial[T](currentSize: Int, size: Int, defaultValue: T): List[T] = 
    if (currentSize < size) defaultValue :: buildInitial(currentSize + 1, size, defaultValue)
    else Nil
  
  def apply[T](rows: Int, cols: Int, defaultValue: T) = new Matrix(buildInitial(0, rows * cols, defaultValue), defaultValue, rows, cols) 
  
}