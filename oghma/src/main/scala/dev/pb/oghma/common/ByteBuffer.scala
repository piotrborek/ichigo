package dev.pb.oghma.common

import dev.pb.oghma.api.ByteWriter

import java.nio.ByteOrder

trait ByteBuffer(buffer: java.nio.ByteBuffer, acc: Vector[java.nio.ByteBuffer]):
  trait Opts:
    def allocBigEndian(capacity: Int): ByteBuffer =
      val buffer = java.nio.ByteBuffer.allocate(capacity)
      buffer.order(ByteOrder.BIG_ENDIAN)
      new ByteBuffer(buffer, acc :+ buffer) {}

    def collect(writer: ByteWriter): Unit =
      for buffer <- acc do writer.write(buffer.array())

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

  def putBytes(value: Array[Byte]): this.type =
    buffer.put(value)
    this

  def complete: this.Opts = new Opts {}

object ByteBuffer:
  def allocBigEndian(capacity: Int): ByteBuffer =
    val buffer = java.nio.ByteBuffer.allocate(capacity)
    buffer.order(ByteOrder.BIG_ENDIAN)
    new ByteBuffer(buffer, Vector(buffer)) {}
