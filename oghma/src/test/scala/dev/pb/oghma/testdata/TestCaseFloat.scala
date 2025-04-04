package dev.pb.oghma.testdata

object TestCaseFloat:
  sealed case class TestCaseFloat32(value: Float, expected: Vector[Byte])
  sealed case class TestCaseFloat64(value: Double, expected: Vector[Byte])

  val casesFloat32: Seq[TestCaseFloat32] = Seq(
    TestCaseFloat32(value = 1.0, expected = Vector(63, 128, 0, 0).map(_.toByte)),
    TestCaseFloat32(value = 3.1415927410125732, expected = Vector(64, 73, 15, 219).map(_.toByte)),
    TestCaseFloat32(value = -1.0, expected = Vector(191, 128, 0, 0).map(_.toByte))
  )
  val casesFloat64: Seq[TestCaseFloat64] = Seq(
    TestCaseFloat64(value = 1.0, expected = Vector(63, 240, 0, 0, 0, 0, 0, 0).map(_.toByte)),
    TestCaseFloat64(value = 3.1415926535, expected = Vector(64, 9, 33, 251, 84, 65, 23, 68).map(_.toByte)),
    TestCaseFloat64(value = -1.0, expected = Vector(191, 240, 0, 0, 0, 0, 0, 0).map(_.toByte))
  )
