package dev.pb.oghma.writer

import dev.pb.oghma.api.{ByteWriter, OghmaWriter}

trait OghmaWriterImpl extends OghmaWriter:
  this: ByteWriter =>

  def writeLong(value: Long): this.type =
    value match
      case x if x >= -128 && x <= 127                 => WriteInt.writeInt8(this, x)
      case x if x >= -32_768 && x <= 32_767           => WriteInt.writeInt16(this, x)
      case x if x >= -2147483648L && x <= 2147483647L => WriteInt.writeInt32(this, x)
      case x                                          => WriteInt.writeInt64(this, x)

    this

  def writeFloat32(value: Float): this.type =
    WriteFloat.writeFloat32(this, value)
    this

  def writeFloat64(value: Double): this.type =
    WriteFloat.writeFloat64(this, value)
    this

  def writeBinary(value: Array[Byte]): this.type =
    value match
      case x if x.length <= 255    => WriteBinary.writeSmallBinary(this, value)
      case x if x.length <= 65_535 => WriteBinary.writeMediumBinary(this, value)
      case x                       => WriteBinary.writeLargeBinary(this, value)
    this
