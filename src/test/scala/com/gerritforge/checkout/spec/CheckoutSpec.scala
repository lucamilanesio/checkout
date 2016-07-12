package com.gerritforge.checkout.spec

import com.gerritforge.checkout.Checkout
import org.scalatest.{FlatSpec, ShouldMatchers}

class CheckoutSpec extends FlatSpec with ShouldMatchers {

  import Checkout._

  "A shop's checkout" should "sell apples" in {
    canSell('apple) should be(true)
  }

  it should "sell oranges" in {
    canSell('orange) should be(true)
  }

  it should "not sell strawberries" in {
    canSell('stawberries) should be(false)
  }

  "An apple" should "cost 60p" in {
    priceOf('apple) should be(60)
  }

  "An orange" should "cost 25p" in {
    priceOf('orange) should be(25)
  }

  "A checkout till" should "price [Apple, Apple, Orange, Apple ] as £1.45" in {
    scan(Seq('apple, 'apple, 'orange, 'apple)) should be(145)
  }

  "A checkout till" should "discount Apples at 50% on multiples of 2" in {
    scan(Seq('apple, 'apple)) should be(60)
  }

  it should "not apply 50% discount on a single Apple" in {
    scan(Seq('apple, 'apple)) should be(60)
  }

  it should "not apply 50% discount on oranges" in {
    scan(Seq('apple, 'orange, 'orange)) should be (110)
  }

  "A checkout till" should "discount Oranges at 3 for the price of 2" in {
    scan(Seq('orange, 'orange, 'orange)) should be(50)
  }

  it should "not apply discounts if buying only two oranges" in {
    scan(Seq('orange, 'orange)) should be (50)
  }

}
