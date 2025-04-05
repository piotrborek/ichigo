package dev.pb.oghma.writer

import dev.pb.oghma.api.ByteWriter
import dev.pb.oghma.common.{ByteBuffer, OghmaTag}

private[writer] object WriteLength:
  def writeSmallLength(writer: ByteWriter, length: Int): Unit =
    require(length <= 255)
    writer
      .write(OghmaTag.SmallLength.toByte)
      .write(length.toByte)

  def writeMediumLength(writer: ByteWriter, length: Int): Unit =
    require(length >= 256 && length <= 65_535)
    ByteBuffer
      .allocBigEndian(3)
      .putByte(OghmaTag.MediumLength.toByte)
      .putShort(length.toShort)
      .collect(writer)

  def writeLargeLength(writer: ByteWriter, length: Int): Unit =
    require(length >= 65_536)
    ByteBuffer
      .allocBigEndian(5)
      .putByte(OghmaTag.LargeLength.toByte)
      .putInt(length)
      .collect(writer)
