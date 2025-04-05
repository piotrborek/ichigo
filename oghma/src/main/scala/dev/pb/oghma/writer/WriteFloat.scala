package dev.pb.oghma.writer

import dev.pb.oghma.api.ByteWriter
import dev.pb.oghma.common.BufferUtils

private[writer] object WriteFloat:
  def marshalFloat32(writer: ByteWriter, value: Float): Unit =
    val buffer = BufferUtils.allocBigEndianByteBuffer(4)
    buffer.putFloat(value)
    writer.write(buffer.array())

  def marshalFloat64(writer: ByteWriter, value: Double): Unit =
    val buffer = BufferUtils.allocBigEndianByteBuffer(8)
    buffer.putDouble(value)
    writer.write(buffer.array())
