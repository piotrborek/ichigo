package dev.pb.oghma.writer

import fs2.{Pure, Stream}
import munit.CatsEffectSuite
import dev.pb.oghma.testdata.TestCaseLong

class OghmaMarshalTest extends CatsEffectSuite:
  test("marshalLong() should return serialized data"):
    for testCase <- TestCaseLong.cases do
      val obtained =
        OghmaMarshal[Pure]
          .marshalLong(testCase.value)
          .toVector
      assertEquals(obtained, testCase.expected)
