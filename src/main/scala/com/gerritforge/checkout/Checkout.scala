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

  def scan(items: Seq[Item]): Int = items.map(priceOf).fold(0)(_ + _) - discountApples(items) - discountOranges(symbol)

  private def discountApples(items: Seq[Item]) = numOfApplePairs(items) * priceOf('apple)

  private def numOfApplePairs(items: Seq[Item]) = items.count(_ == 'apple) / 2

  private def discountOranges(items: Seq[Item]) = numOfOrangesTriples(items) * priceOf('orange)

  private def numOfOrangesTriples(items: Seq[Item]) = items.count(_ == 'orange) / 3
}
