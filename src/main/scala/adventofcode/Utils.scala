package adventofcode

import cats.effect.{ IO, Resource }

import scala.io.Source

object Utils {
  def readInput(file: String): IO[List[String]] =
    Resource
      .fromAutoCloseable(IO(Source.fromURL(getClass.getClassLoader.getResource(s"$file.txt"))))
      .use { source =>
        IO(source.getLines().toList)
      }
}
