package dev.pb.oghma.writer

import dev.pb.oghma.api.ByteWriter
import dev.pb.oghma.common.{BufferUtils, OghmaTag}
import fs2.Stream

private[writer] object WriteInt:
  def marshalInt8(writer: ByteWriter, value: Long): Unit =
    val buffer = BufferUtils.allocBigEndianByteBuffer(2)
    buffer.put(OghmaTag.Int8.toByte)
    buffer.put(value.toByte)
    writer.write(buffer.array())

  def marshalInt16(writer: ByteWriter, value: Long): Unit =
    val buffer = BufferUtils.allocBigEndianByteBuffer(3)
    buffer.put(OghmaTag.Int16.toByte)
    buffer.putShort(value.toShort)
    writer.write(buffer.array())

  def marshalInt32(writer: ByteWriter, value: Long): Unit =
    val buffer = BufferUtils.allocBigEndianByteBuffer(5)
    buffer.put(OghmaTag.Int32.toByte)
    buffer.putInt(value.toInt)
    writer.write(buffer.array())

  def marshalInt64(writer: ByteWriter, value: Long): Unit =
    val buffer = BufferUtils.allocBigEndianByteBuffer(9)
    buffer.put(OghmaTag.Int64.toByte)
    buffer.putLong(value)
    writer.write(buffer.array())
