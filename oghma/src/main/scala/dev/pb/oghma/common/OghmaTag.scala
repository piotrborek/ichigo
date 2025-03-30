package dev.pb.oghma.common

enum OghmaTag(val value: Int):
  case Int8 extends OghmaTag(0x08)
  case Int16 extends OghmaTag(0x10)
  case Int32 extends OghmaTag(0x20)
  case Int64 extends OghmaTag(0x40)
  case SmallLength extends OghmaTag(0xb0.toByte)
  case MediumLength extends OghmaTag(0xb1.toByte)
  case LargeLength extends OghmaTag(0xb2.toByte)
