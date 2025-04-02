package dev.pb.oghma.api

import fs2.Stream

trait Marshal[F[_]]:
  def marshalLong(value: Long): Stream[F, Byte]
  def marshalInt(value: Int): Stream[F, Byte] = marshalLong(value)
  def marshalShort(value: Short): Stream[F, Byte] = marshalLong(value)
  def marshalByte(value: Byte): Stream[F, Byte] = marshalLong(value)
