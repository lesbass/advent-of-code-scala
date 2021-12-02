package adventofcode

import scala.util.Try

object Day1 {

  import adventofcode.Utils._
  import cats.effect._
  import cats.implicits._

  def executePart1(file: String): IO[Int] = readInput(file)
    .map(x => part1(x))

  def parseMeasurement(raw: String): Try[Measurement] = Try {
    Measurement(raw.toInt)
  }

  def part1(input: List[String]): Int = input
    .map(parseMeasurement)
    .sequence
    .map(_.foldLeft((Counter(0), Measurement(0), 0)) { (acc, currMeasure) =>
      val (counter, prevMeasure, index) = acc
      (counter.increaseIfTrue(index > 0 && currMeasure.value > prevMeasure.value), currMeasure, index + 1)
    })
    .fold(_ => 0, x => x._1.value)

  def part2(input: Array[String]): Int = input.length

  case class Measurement(value: Int)
  case class Counter(value: Int) {
    def increaseIfTrue(expr: Boolean): Counter = if (expr) copy(value = value + 1) else this
  }
}
