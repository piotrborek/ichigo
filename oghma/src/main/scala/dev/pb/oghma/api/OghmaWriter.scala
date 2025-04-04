package dev.pb.oghma.api

trait OghmaWriter:
  this: ByteWriter =>

  def writeLong(value: Long): this.type
  def writeInt(value: Int): this.type = writeLong(value)
  def writeShort(value: Short): this.type = writeLong(value)
  def writeByte(value: Byte): this.type = writeLong(value)

  def writeFloat32(value: Float): this.type
  def writeFloat64(value: Double): this.type
