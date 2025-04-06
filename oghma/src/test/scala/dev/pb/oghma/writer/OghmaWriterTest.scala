package dev.pb.oghma.writer

import dev.pb.oghma.api.ByteWriter
import dev.pb.oghma.common.{ByteBuffer, OghmaTag}
import munit.FunSuite
import dev.pb.oghma.testdata.{TestCaseFloat, TestCaseLong}

import java.time.LocalDateTime

class OghmaWriterTest extends FunSuite:
  test("writeLong() should write data"):
    for testCase <- TestCaseLong.cases do
      val obtained =
        MemoryOghmaWriter()
          .writeLong(testCase.value)
          .toVector
      assertEquals(obtained, testCase.expected)

  test("writeFloat32() should write data"):
    for testCase <- TestCaseFloat.casesFloat32 do
      val obtained =
        MemoryOghmaWriter()
          .writeFloat32(testCase.value)
          .toVector
      assertEquals(obtained, testCase.expected)

  test("writeFloat64() should write data"):
    for testCase <- TestCaseFloat.casesFloat64 do
      val obtained =
        MemoryOghmaWriter()
          .writeFloat64(testCase.value)
          .toVector
      assertEquals(obtained, testCase.expected)

  test("writeBinary() should write small binary data"):
    val obtained =
      MemoryOghmaWriter()
        .writeBinary(Array(1, 2, 3, 4))
        .toVector
    assertEquals(obtained, Vector(OghmaTag.SmallLength.toInt, 4, 1, 2, 3, 4).map(_.toByte))

  test("writeBinary() should write small binary data - 255 bytes binary"):
    val bytes = Range.inclusive(1, 255).map(_.toByte).toArray
    val expected = Vector(OghmaTag.SmallLength.toInt, 255).map(_.toByte).appendedAll(bytes)
    val obtained =
      MemoryOghmaWriter()
        .writeBinary(bytes)
        .toVector
    assertEquals(obtained, expected)

  test("writeBinary() should write small binary data - 65535 bytes binary"):
    val bytes = Range.inclusive(1, 512).map(_.toByte).toArray
    val expected = Vector(OghmaTag.MediumLength.toInt, 2, 0).map(_.toByte).appendedAll(bytes)
    val obtained =
      MemoryOghmaWriter()
        .writeBinary(bytes)
        .toVector
    assertEquals(obtained, expected)

  test("writeBinary() should write small binary data - 512 bytes binary"):
    val bytes = Range.inclusive(1, 65535).map(_.toByte).toArray
    val expected = Vector(OghmaTag.MediumLength.toInt, 255, 255).map(_.toByte).appendedAll(bytes)
    val obtained =
      MemoryOghmaWriter()
        .writeBinary(bytes)
        .toVector
    assertEquals(obtained, expected)

  test("writeBinary() should write small binary data - 131072 bytes binary"):
    val bytes = Range.inclusive(1, 131072).map(_.toByte).toArray
    val expected = Vector(OghmaTag.LargeLength.toInt, 0, 2, 0, 0).map(_.toByte).appendedAll(bytes)
    val obtained =
      MemoryOghmaWriter()
        .writeBinary(bytes)
        .toVector
    assertEquals(obtained, expected)

  test("writeDateTime should write data - test 1"):
    val dateTime = LocalDateTime.parse("2025-04-06T21:04:27.228705428")
    val expected = Vector(0x20, 0x25, 0xf4, 0x06, 0x21, 0x04, 0x27, 0x22, 0x87, 0x05, 0x42, 0x8f).map(_.toByte)
    val obtained =
      MemoryOghmaWriter()
        .writeDateTime(dateTime)
        .toVector
    assertEquals(obtained, expected)

  test("writeDateTime should write data - test 1"):
    val dateTime = LocalDateTime.parse("2025-04-06T21:04:27.022870542")
    val expected = Vector(0x20, 0x25, 0xf4, 0x06, 0x21, 0x04, 0x27, 0x22, 0x87, 0x05, 0x42, 0xf0).map(_.toByte)
    val obtained =
      MemoryOghmaWriter()
        .writeDateTime(dateTime)
        .toVector

    assertEquals(obtained, expected)
