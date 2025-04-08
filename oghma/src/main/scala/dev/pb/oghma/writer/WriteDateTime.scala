package dev.pb.oghma.writer

import dev.pb.oghma.common.ByteBuffer

import java.time.LocalDateTime
import scala.annotation.tailrec
import scala.collection.mutable

object WriteDateTime:
  def writeDateTime(dateTime: LocalDateTime): ByteBuffer#Opts =
    val array = mutable.ArrayBuffer[Int]()
    anyIntToBCD(dateTime.getNano, array)
    boundedIntToBCD(dateTime.getSecond, 2, array)
    boundedIntToBCD(dateTime.getMinute, 2, array)
    boundedIntToBCD(dateTime.getHour, 2, array)
    boundedIntToBCD(dateTime.getDayOfMonth, 2, array)
    array += dateTime.getMonth.getValue.toByte
    array += 0xf
    anyIntToBCD(dateTime.getYear, array)

    val zipped = zipArray(array).toArray
    ByteBuffer
      .allocBigEndian(zipped.length)
      .putBytes(zipped)
      .complete

  @tailrec
  private def anyIntToBCD(value: Int, acc: mutable.ArrayBuffer[Int]): Unit =
    value match
      case 0 if acc.isEmpty =>
        acc += 0
      case 0 => ()
      case _ =>
        acc += value % 10
        anyIntToBCD(value / 10, acc)

  @tailrec
  private def boundedIntToBCD(value: Int, numOfDigits: Int, acc: mutable.ArrayBuffer[Int]): Unit =
    numOfDigits match
      case 0 => ()
      case _ =>
        acc += value % 10
        boundedIntToBCD(value / 10, numOfDigits - 1, acc)

  private def valueFromIt(it: Iterator[Int]) = if it.hasNext then it.next() else 0xf

  private def zipArray(buffer: mutable.ArrayBuffer[Int]): mutable.ArrayBuffer[Byte] =
    val output = mutable.ArrayBuffer[Byte]()
    val it = buffer.reverseIterator
    var last = 0
    while (it.hasNext) do
      val byte1 = valueFromIt(it)
      val byte0 = valueFromIt(it)
      last = byte0
      output += (((byte1 << 4) & 0xf0) + (byte0 & 0x0f)).toByte

    if last != 0xf then output += 0xff.toByte
    output
