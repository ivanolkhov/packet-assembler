import org.scalatest.funsuite.AnyFunSuite

class PacketAssemblerTest extends AnyFunSuite {
  test("SplitLine test 1") {
    assert(PacketAssembler.splitLine("6220 1 10	Because he's the hero Gotham deserves,") === (6220, 1, 10, "Because he's the hero Gotham deserves,"))

  }

}
