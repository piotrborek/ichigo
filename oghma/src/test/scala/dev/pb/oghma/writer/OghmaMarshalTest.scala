package dev.pb.oghma.writer

import fs2.{Pure, Stream}
import munit.CatsEffectSuite
import dev.pb.oghma.testdata.{TestCaseFloat, TestCaseLong}

class OghmaMarshalTest extends CatsEffectSuite:
  test("marshalLong() should return serialized data"):
    for testCase <- TestCaseLong.cases do
      val obtained =
        OghmaMarshal[Pure]
          .marshalLong(testCase.value)
          .toVector
      assertEquals(obtained, testCase.expected)

  test("marshalFloat32() should return serialized data"):
    for testCase <- TestCaseFloat.casesFloat32 do
      val obtained =
        OghmaMarshal[Pure]
          .marshalFloat32(testCase.value)
          .toVector
      assertEquals(obtained, testCase.expected)

  test("marshalFloat64() should return serialized data"):
    for testCase <- TestCaseFloat.casesFloat64 do
      val obtained =
        OghmaMarshal[Pure]
          .marshalFloat64(testCase.value)
          .toVector
      assertEquals(obtained, testCase.expected)
