object PacketAssembler {
    def splitLine(text: String):  (Int, Int, Int, String) = {
      val textarray = text.split("\\s+")
      val part1 = textarray(0).toInt
      val part2 = textarray(1).toInt
      val part3 = textarray(2).toInt
      val part4 = textarray.slice(3, textarray.length).mkString(" ")
      (part1, part2, part3, part4)
    }

}
