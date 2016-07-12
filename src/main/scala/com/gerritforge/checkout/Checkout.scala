package com.gerritforge.checkout

object Checkout {

  type Item = Symbol

  def canSell(item: Item) = item match {
    case 'apple => true
    case 'orange => true
    case _ => false
  }

  def priceOf(item: Item) = getPriceOption(item).get

  private def getPriceOption(products: Symbol): Option[Int] = products match {
    case 'apple => Some(60)
    case 'orange => Some(25)
    case _ => None
  }

}
