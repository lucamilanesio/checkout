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
}
