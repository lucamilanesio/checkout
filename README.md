# Checkout Exercise

Implementation of a checkout system responsible for scanning and pricing a list of items on sale.

## Assumptions

Items on sale are Scala symbols and are limited to apple and orange.
Prices are Int and expressed in pence. E.g. 1 pound is expressed as 100.

## Pre-requisites

Scala 2.11.x
SBT 0.13.x

## Build

```
   $ sbt package
```

## Test

```
   $ sbt test
```

## Using the checkout

The Shop's Checkout is implemented with a class object called com.gerritforge.checkout.Checkout.
In order to use the Checkout simply import all its methods and use them.

The Checkout entrypoint is the scan() function which takes a variable number of symbols and return the
total price.

Example:

```
   $ scala -classpath target/scala-2.11/checkoutexercise_2.11-1.0.jar

   scala> import com.gerritforge.checkout.Checkout._

   val items =  Seq( 'apple, 'apple, 'orange, 'apple )
   val price = scan(items)
   println(s"Total price of $items is $price")
```