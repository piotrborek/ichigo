package dev.pb.oghma.common

import java.nio.{ByteBuffer, ByteOrder}
import fs2.Stream

object BufferUtils:
  def bigEndianByteBuffer(bytes: Int*): ByteBuffer =
    val buffer = allocBigEndianByteBuffer(bytes.size)
    buffer.put(bytes.map(_.toByte).toArray)
    buffer

  def toStream[F[_]](buffer: ByteBuffer): Stream[F, Byte] = Stream(buffer.array()*)

  private def allocBigEndianByteBuffer(capacity: Int): ByteBuffer =
    val buffer = ByteBuffer.allocate(capacity)
    buffer.order(ByteOrder.BIG_ENDIAN)
    buffer
