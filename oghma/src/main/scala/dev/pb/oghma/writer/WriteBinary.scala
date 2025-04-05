package dev.pb.oghma.writer

import dev.pb.oghma.common.ByteBuffer

private[writer] object WriteBinary:
  def writeSmallBinary(value: Array[Byte]): ByteBuffer#Opts =
    WriteLength
      .writeSmallLength(value.length)
      .allocBigEndian(value.length)
      .putBytes(value)
      .complete

  def writeMediumBinary(value: Array[Byte]): ByteBuffer#Opts =
    WriteLength
      .writeMediumLength(value.length)
      .allocBigEndian(value.length)
      .putBytes(value)
      .complete

  def writeLargeBinary(value: Array[Byte]): ByteBuffer#Opts =
    WriteLength
      .writeLargeLength(value.length)
      .allocBigEndian(value.length)
      .putBytes(value)
      .complete
