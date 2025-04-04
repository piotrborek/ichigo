package dev.pb.oghma.writer

import fs2.Stream
import dev.pb.oghma.api.Marshal

sealed trait OghmaMarshal[F[_]] extends Marshal[F]:
  def marshalLong(value: Long): Stream[F, Byte] =
    value match
      case x if x >= -128 && x <= 127                 => MarshalInt.marshalInt8(x)
      case x if x >= -32_768 && x <= 32_767           => MarshalInt.marshalInt16(x)
      case x if x >= -2147483648L && x <= 2147483647L => MarshalInt.marshalInt32(x)
      case x                                          => MarshalInt.marshalInt64(x)

  def marshalFloat32(value: Float): Stream[F, Byte] = MarshaFloat.marshalFloat32(value)

  def marshalFloat64(value: Double): Stream[F, Byte] = MarshaFloat.marshalFloat64(value)

object OghmaMarshal:
  def apply[F[_]](using F: OghmaMarshal[F]): Marshal[F] = F

  given [F[_]] => OghmaMarshal[F]:
    export OghmaMarshal.*
