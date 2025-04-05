package dev.pb.oghma.common

import dev.pb.oghma.api.ByteWriter

import java.nio.ByteOrder

trait ByteBuffer(buffer: java.nio.ByteBuffer):
  def putByte(value: Byte): this.type =
    buffer.put(value)
    this

  def putShort(value: Short): this.type =
    buffer.putShort(value)
    this

  def putInt(value: Int): this.type =
    buffer.putInt(value)
    this

  def putLong(value: Long): this.type =
    buffer.putLong(value)
    this

  def putFloat(value: Float): this.type =
    buffer.putFloat(value)
    this

  def putDouble(value: Double): this.type =
    buffer.putDouble(value)
    this

  def collect(writer: ByteWriter): Unit =
    writer.write(buffer.array())

object ByteBuffer:
  private class ByteBufferImpl(buffer: java.nio.ByteBuffer) extends ByteBuffer(buffer)

  def allocBigEndian(capacity: Int): ByteBuffer =
    val buffer = java.nio.ByteBuffer.allocate(capacity)
    buffer.order(ByteOrder.BIG_ENDIAN)
    ByteBufferImpl(buffer)
