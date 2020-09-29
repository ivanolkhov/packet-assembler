import org.scalatest.funsuite.AnyFunSuite

class PacketAssemblerTest extends AnyFunSuite {
  test("SplitLine test 1") {
    assert(PacketAssembler.splitLine("6220 1 10	Because he's the hero Gotham deserves,") === (6220, 1, 10, "Because he's the hero Gotham deserves,"))

  }
  test("Parser test") {
    val m1 = PacketAssembler.parser((10, 1, 10, "hello"), Map())
    assert(m1 === Map(10 -> List((1, 10, "hello"))))
    val m2 = PacketAssembler.parser((10, 5, 10, "world"), m1)
    assert(m2 === Map(10 -> List((5, 10, "world"),(1, 10, "hello"))))
  }

}
