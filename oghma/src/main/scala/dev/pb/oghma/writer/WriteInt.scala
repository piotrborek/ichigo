package dev.pb.oghma.writer

import dev.pb.oghma.api.ByteWriter
import dev.pb.oghma.common.{ByteBuffer, OghmaTag}
import fs2.Stream

private[writer] object WriteInt:
  def writeInt8(writer: ByteWriter, value: Long): Unit =
    ByteBuffer
      .allocBigEndian(2)
      .putByte(OghmaTag.Int8.toByte)
      .putByte(value.toByte)
      .collect(writer)

  def writeInt16(writer: ByteWriter, value: Long): Unit =
    ByteBuffer
      .allocBigEndian(3)
      .putByte(OghmaTag.Int16.toByte)
      .putShort(value.toShort)
      .collect(writer)

  def writeInt32(writer: ByteWriter, value: Long): Unit =
    ByteBuffer
      .allocBigEndian(5)
      .putByte(OghmaTag.Int32.toByte)
      .putInt(value.toInt)
      .collect(writer)

  def writeInt64(writer: ByteWriter, value: Long): Unit =
    ByteBuffer
      .allocBigEndian(9)
      .putByte(OghmaTag.Int64.toByte)
      .putLong(value)
      .collect(writer)
