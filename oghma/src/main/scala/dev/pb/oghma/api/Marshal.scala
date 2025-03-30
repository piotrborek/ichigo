package dev.pb.oghma.api

import fs2.Stream

trait Marshal[F[_]]:
  def marshalInt(value: Long): Stream[F, Byte]
