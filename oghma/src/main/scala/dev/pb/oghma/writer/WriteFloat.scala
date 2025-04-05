package dev.pb.oghma.writer

import dev.pb.oghma.api.ByteWriter
import dev.pb.oghma.common.ByteBuffer

private[writer] object WriteFloat:
  def writeFloat32(writer: ByteWriter, value: Float): Unit =
    ByteBuffer
      .allocBigEndian(4)
      .putFloat(value)
      .collect(writer)

  def writeFloat64(writer: ByteWriter, value: Double): Unit =
    ByteBuffer
      .allocBigEndian(8)
      .putDouble(value)
      .collect(writer)
