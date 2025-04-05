package dev.pb.oghma.api

trait ByteWriter:
  def write(b: Byte): this.type
  def write(b: Array[Byte]): this.type
