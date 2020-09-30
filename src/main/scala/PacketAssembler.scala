import scala.io.StdIn.readLine

object PacketAssembler extends App {
  var acc = Map[Int, List[(Int, Int, String)]]()
  while (true) {
    val line = readLine("enter: ")
    acc = parser(splitLine(line), acc)
    val fMessages = fullMessages(acc)
    for (i <- fMessages) {
      printMessage(acc(i))
      acc = acc - i
    }
  }

  def splitLine(text: String): (Int, Int, Int, String) = {
    val textarray = text.split("\\s+")
    val part1 = textarray(0).toInt
    val part2 = textarray(1).toInt
    val part3 = textarray(2).toInt
    val part4 = textarray.slice(3, textarray.length).mkString(" ")
    (part1, part2, part3, part4)
  }

  def parser(tuple: (Int, Int, Int, String),
             acc: Map[Int, List[(Int, Int, String)]]): Map[Int, List[(Int, Int, String)]] = {
    val msgid = tuple._1
    val content = (tuple._2, tuple._3, tuple._4)
    acc + (msgid -> acc.get(msgid).map(l => content :: l).getOrElse(List(content)))

  }

  def fullMessages(acc: Map[Int, List[(Int, Int, String)]]): List[Int] = {
    acc.map {
      case (k, l) => {
        val expectedLines = l.head._2
        val actualLines = l.length
        if (expectedLines == actualLines) Some(k) else None
      }
    }.filter(_.isDefined).map(_.get).toList
  }

  def printMessage(msgs: List[(Int, Int, String)]): Unit = {
    msgs.sortBy(_._1).foreach(x => (println(x._3)))
  }
}

