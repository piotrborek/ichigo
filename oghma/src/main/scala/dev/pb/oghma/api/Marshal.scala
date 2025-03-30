package dev.pb.oghma.api

import fs2.Stream

trait Marshal[F[_]]:
  def marshalInt(int: Int): Stream[F, Byte]
