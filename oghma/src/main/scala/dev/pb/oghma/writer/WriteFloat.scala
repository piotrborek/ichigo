package dev.pb.oghma.writer

import dev.pb.oghma.common.ByteBuffer

private[writer] object WriteFloat:
  def writeFloat32(value: Float): ByteBuffer#Opts =
    ByteBuffer
      .allocBigEndian(4)
      .putFloat(value)
      .complete

  def writeFloat64(value: Double): ByteBuffer#Opts =
    ByteBuffer
      .allocBigEndian(8)
      .putDouble(value)
      .complete
