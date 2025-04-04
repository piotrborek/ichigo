package dev.pb.oghma.writer

import dev.pb.oghma.common.BufferUtils
import fs2.Stream

private[writer] object MarshaFloat:
  def marshalFloat32[F[_]](value: Float): Stream[F, Byte] =
    val buffer = BufferUtils.allocBigEndianByteBuffer(4)
    buffer.putFloat(value)
    BufferUtils.toStream(buffer)

  def marshalFloat64[F[_]](value: Double): Stream[F, Byte] =
    val buffer = BufferUtils.allocBigEndianByteBuffer(8)
    buffer.putDouble(value)
    BufferUtils.toStream(buffer)
