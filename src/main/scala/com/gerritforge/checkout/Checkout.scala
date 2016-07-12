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

  def scan(items: Seq[Item]): Int = items.map(priceOf).fold(0)(_ + _) - discountApples(items) - discountOranges(items)

  private def discountApples = discount('apple, 2)(_)

  private def discountOranges = discount('orange, 3)(_)

  private def discount(discountedItem: Item, itemCount: Int)(items: Seq[Item]) = items.count(_ == discountedItem) / itemCount * priceOf(discountedItem)
}
