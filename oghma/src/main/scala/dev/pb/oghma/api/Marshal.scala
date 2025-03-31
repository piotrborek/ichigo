package dev.pb.oghma.api

import fs2.Stream

trait Marshal[F[_]]:
  def marshalLong(value: Long): Stream[F, Byte]
  def marshalInt(value: Int): Stream[F, Byte] = marshalLong(value)
