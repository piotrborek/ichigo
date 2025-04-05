package dev.pb.oghma.writer

import munit.FunSuite
import dev.pb.oghma.testdata.{TestCaseFloat, TestCaseLong}

class OghmaWriterTest extends FunSuite:
  test("marshalLong() should return serialized data"):
    for testCase <- TestCaseLong.cases do
      val obtained =
        MemoryOghmaWriter()
          .writeLong(testCase.value)
          .toVector
      assertEquals(obtained, testCase.expected)

  test("marshalFloat32() should return serialized data"):
    for testCase <- TestCaseFloat.casesFloat32 do
      val obtained =
        MemoryOghmaWriter()
          .writeFloat32(testCase.value)
          .toVector
      assertEquals(obtained, testCase.expected)

  test("marshalFloat64() should return serialized data"):
    for testCase <- TestCaseFloat.casesFloat64 do
      val obtained =
        MemoryOghmaWriter()
          .writeFloat64(testCase.value)
          .toVector
      assertEquals(obtained, testCase.expected)
