package dev.pb.oghma.writer

import dev.pb.oghma.api.ByteWriter

import scala.collection.mutable

class MemoryOghmaWriter extends OghmaWriterImpl with ByteWriter:
  private val buffer = mutable.ArrayBuffer.empty[Byte]

  def write(b: Byte): this.type =
    buffer.append(b)
    this

  def write(b: Array[Byte]): this.type =
    buffer.appendAll(b)
    this

  def toVector: Vector[Byte] = buffer.toVector
