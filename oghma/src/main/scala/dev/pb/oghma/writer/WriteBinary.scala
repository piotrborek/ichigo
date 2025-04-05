package dev.pb.oghma.writer

import dev.pb.oghma.api.ByteWriter

private[writer] object WriteBinary:
  def writeSmallBinary(writer: ByteWriter, value: Array[Byte]): Unit =
    WriteLength.writeSmallLength(writer, value.length)
    writer.write(value)

  def writeMediumBinary(writer: ByteWriter, value: Array[Byte]): Unit =
    WriteLength.writeMediumLength(writer, value.length)
    writer.write(value)

  def writeLargeBinary(writer: ByteWriter, value: Array[Byte]): Unit =
    WriteLength.writeLargeLength(writer, value.length)
    writer.write(value)
