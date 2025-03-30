package dev.pb.oghma.writer

import dev.pb.oghma.common.OghmaTag
import fs2.Pure
import munit.CatsEffectSuite

class OghmaMarshalTest extends CatsEffectSuite:
  test("Example test"):
    val obtained = OghmaMarshal[Pure].marshalInt(0).toVector
    val expected = Vector(OghmaTag.Int8.value, 0).map(_.toByte)

    assertEquals(obtained, expected)
