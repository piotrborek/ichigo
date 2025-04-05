package dev.pb.oghma.writer

import dev.pb.oghma.api.{ByteWriter, OghmaWriter}

trait OghmaWriterImpl extends OghmaWriter:
  this: ByteWriter =>

  def writeLong(value: Long): this.type =
    value match
      case x if x >= -128 && x <= 127                 => WriteInt.marshalInt8(this, x)
      case x if x >= -32_768 && x <= 32_767           => WriteInt.marshalInt16(this, x)
      case x if x >= -2147483648L && x <= 2147483647L => WriteInt.marshalInt32(this, x)
      case x                                          => WriteInt.marshalInt64(this, x)

    this

  def writeFloat32(value: Float): this.type =
    WriteFloat.marshalFloat32(this, value)
    this

  def writeFloat64(value: Double): this.type =
    WriteFloat.marshalFloat64(this, value)
    this
