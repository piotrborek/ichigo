package dev.pb.oghma.writer

import dev.pb.oghma.common.{BufferUtils, OghmaTag}
import fs2.Stream

private[writer] object MarshalInt:
  def marshalInt8[F[_]](value: Long): Stream[F, Byte] =
    val buffer = BufferUtils.allocBigEndianByteBuffer(2)
    buffer.put(OghmaTag.Int8.toByte)
    buffer.put(value.toByte)
    BufferUtils.toStream(buffer)

  def marshalInt16[F[_]](value: Long): Stream[F, Byte] =
    val buffer = BufferUtils.allocBigEndianByteBuffer(3)
    buffer.put(OghmaTag.Int16.toByte)
    buffer.putShort(value.toShort)
    BufferUtils.toStream(buffer)

  def marshalInt32[F[_]](value: Long): Stream[F, Byte] =
    val buffer = BufferUtils.allocBigEndianByteBuffer(5)
    buffer.put(OghmaTag.Int32.toByte)
    buffer.putInt(value.toInt)
    BufferUtils.toStream(buffer)

  def marshalInt64[F[_]](value: Long): Stream[F, Byte] =
    val buffer = BufferUtils.allocBigEndianByteBuffer(9)
    buffer.put(OghmaTag.Int64.toByte)
    buffer.putLong(value)
    BufferUtils.toStream(buffer)
