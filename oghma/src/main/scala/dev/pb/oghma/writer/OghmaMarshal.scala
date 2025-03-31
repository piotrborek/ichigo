package dev.pb.oghma.writer

import fs2.Stream
import dev.pb.oghma.api.Marshal
import dev.pb.oghma.common.{BufferUtils, OghmaTag}

sealed trait OghmaMarshal[F[_]] extends Marshal[F]:
  def marshalLong(value: Long): Stream[F, Byte] =
    value match
      case x if x >= -128 && x <= 127 => marshalInt8(x)

  private def marshalInt8(value: Long): Stream[F, Byte] =
    val buffer = BufferUtils.bigEndianByteBuffer(OghmaTag.Int8.value, value.toByte)
    BufferUtils.toStream(buffer)

object OghmaMarshal:
  def apply[F[_]](using F: OghmaMarshal[F]): Marshal[F] = F

  given [F[_]] => OghmaMarshal[F]:
    export OghmaMarshal.*
