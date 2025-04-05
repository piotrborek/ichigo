package dev.pb.oghma.writer

import dev.pb.oghma.common.{ByteBuffer, OghmaTag}

private[writer] object WriteLength:
  def writeSmallLength(length: Int): ByteBuffer#Opts =
    require(length <= 255)
    ByteBuffer
      .allocBigEndian(2)
      .putByte(OghmaTag.SmallLength.toByte)
      .putByte(length.toByte)
      .complete

  def writeMediumLength(length: Int): ByteBuffer#Opts =
    require(length >= 256 && length <= 65_535)
    ByteBuffer
      .allocBigEndian(3)
      .putByte(OghmaTag.MediumLength.toByte)
      .putShort(length.toShort)
      .complete

  def writeLargeLength(length: Int): ByteBuffer#Opts =
    require(length >= 65_536)
    ByteBuffer
      .allocBigEndian(5)
      .putByte(OghmaTag.LargeLength.toByte)
      .putInt(length)
      .complete
