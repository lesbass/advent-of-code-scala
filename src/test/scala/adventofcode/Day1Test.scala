package adventofcode

class Day1Test extends munit.FunSuite {

  import adventofcode.Day1._

  test("part1 test") {
    val program = executePart1("Day01_test")
    val result  = program.unsafeRunSync()
    assertEquals(result, 7)
  }

  test("part1") {
    val program = executePart1("Day01")
    val result  = program.unsafeRunSync()
    assertEquals(result, 1624)
  }
}
