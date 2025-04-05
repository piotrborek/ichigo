package dev.pb.oghma.writer

import dev.pb.oghma.common.{ByteBuffer, OghmaTag}

private[writer] object WriteInt:
  def writeInt8(value: Long): ByteBuffer#Opts =
    ByteBuffer
      .allocBigEndian(2)
      .putByte(OghmaTag.Int8.toByte)
      .putByte(value.toByte)
      .complete

  def writeInt16(value: Long): ByteBuffer#Opts =
    ByteBuffer
      .allocBigEndian(3)
      .putByte(OghmaTag.Int16.toByte)
      .putShort(value.toShort)
      .complete

  def writeInt32(value: Long): ByteBuffer#Opts =
    ByteBuffer
      .allocBigEndian(5)
      .putByte(OghmaTag.Int32.toByte)
      .putInt(value.toInt)
      .complete

  def writeInt64(value: Long): ByteBuffer#Opts =
    ByteBuffer
      .allocBigEndian(9)
      .putByte(OghmaTag.Int64.toByte)
      .putLong(value)
      .complete
