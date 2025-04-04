package dev.pb.oghma.testdata

import dev.pb.oghma.common.OghmaTag

object TestCaseLong:
  sealed case class TestCase(value: Long, expected: Vector[Byte])

  val cases: Seq[TestCase] = Seq(
    TestCase(value = 0, expected = Vector(OghmaTag.Int8.toInt, 0).map(_.toByte)),
    TestCase(value = 1, expected = Vector(OghmaTag.Int8.toInt, 1).map(_.toByte)),
    TestCase(value = 100, expected = Vector(OghmaTag.Int8.toInt, 100).map(_.toByte)),
    TestCase(value = 127, expected = Vector(OghmaTag.Int8.toInt, 0x7f).map(_.toByte)),
    TestCase(value = 128, expected = Vector(OghmaTag.Int16.toInt, 0x00, 0x80).map(_.toByte)),
    TestCase(value = 255, expected = Vector(OghmaTag.Int16.toInt, 0x00, 0xff).map(_.toByte)),
    TestCase(value = 256, expected = Vector(OghmaTag.Int16.toInt, 0x01, 0x00).map(_.toByte)),
    TestCase(value = 15000, expected = Vector(OghmaTag.Int16.toInt, 0x3a, 0x98).map(_.toByte)),
    TestCase(value = 32767, expected = Vector(OghmaTag.Int16.toInt, 0x7f, 0xff).map(_.toByte)),
    TestCase(value = 32768, expected = Vector(OghmaTag.Int32.toInt, 0x00, 0x00, 0x80, 0x00).map(_.toByte)),
    TestCase(value = 65536, expected = Vector(OghmaTag.Int32.toInt, 0x00, 0x01, 0x00, 0x00).map(_.toByte)),
    TestCase(value = 100_000, expected = Vector(OghmaTag.Int32.toInt, 0x00, 0x01, 0x86, 0xa0).map(_.toByte)),
    TestCase(value = 1_000_000, expected = Vector(OghmaTag.Int32.toInt, 0x00, 0x0f, 0x42, 0x040).map(_.toByte)),
    TestCase(value = 2_147_483_647, expected = Vector(OghmaTag.Int32.toInt, 0x7f, 0xff, 0xff, 0xff).map(_.toByte)),
    TestCase(
      value = 2_147_483_648L,
      expected = Vector(OghmaTag.Int64.toInt, 0x00, 0x00, 0x00, 0x00, 0x80, 0x00, 0x00, 0x00).map(_.toByte)
    ),
    TestCase(value = -1, Vector(OghmaTag.Int8.toInt, 0xff).map(_.toByte)),
    TestCase(value = -100, Vector(OghmaTag.Int8.toInt, 0x9c).map(_.toByte)),
    TestCase(value = -128, Vector(OghmaTag.Int8.toInt, 0x80).map(_.toByte)),
    TestCase(value = -129, Vector(OghmaTag.Int16.toInt, 0xff, 0x7f).map(_.toByte)),
    TestCase(value = -255, Vector(OghmaTag.Int16.toInt, 0xff, 0x01).map(_.toByte)),
    TestCase(value = -256, Vector(OghmaTag.Int16.toInt, 0xff, 0x00).map(_.toByte)),
    TestCase(value = -15000, Vector(OghmaTag.Int16.toInt, 0xc5, 0x68).map(_.toByte)),
    TestCase(value = -32768, Vector(OghmaTag.Int16.toInt, 0x80, 0x00).map(_.toByte)),
    TestCase(value = -32769, Vector(OghmaTag.Int32.toInt, 0xff, 0xff, 0x7f, 0xff).map(_.toByte)),
    TestCase(value = -65535, Vector(OghmaTag.Int32.toInt, 0xff, 0xff, 0x00, 0x01).map(_.toByte)),
    TestCase(value = -65536, Vector(OghmaTag.Int32.toInt, 0xff, 0xff, 0x00, 0x00).map(_.toByte)),
    TestCase(value = -2_147_483_648L, Vector(OghmaTag.Int32.toInt, 0x80, 0x00, 0x00, 0x00).map(_.toByte)),
    TestCase(
      value = -2_147_483_649L,
      Vector(OghmaTag.Int64.toInt, 0xff, 0xff, 0xff, 0xff, 0x7f, 0xff, 0xff, 0xff).map(_.toByte)
    ),
    TestCase(
      value = -9_223_372_036_854_775_808L,
      Vector(OghmaTag.Int64.toInt, 0x80, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00).map(_.toByte)
    )
  )
