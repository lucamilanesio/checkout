package com.gerritforge.checkout

object Checkout {

  type Item = Symbol

  def priceOf(item: Item) = getPriceOption(item).get

  private def getPriceOption(item: Item): Option[Int] = item match {
    case 'apple => Some(60)
    case 'orange => Some(25)
    case _ => None
  }

  def canSell(symbol: Item) = getPriceOption(symbol).isDefined

  def scan(symbol: Seq[Symbol]): Int = symbol.map(priceOf).fold(0)(_ + _)
}
