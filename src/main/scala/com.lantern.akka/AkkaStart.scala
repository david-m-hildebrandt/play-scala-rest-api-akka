package com.lantern.akka

import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

object AkkaStart {

  implicit val ec = scala.concurrent.ExecutionContext.global

  def printMessage(delay: Int, message: String) = {
    println(s"Thread[${Thread.currentThread().getName}] $message")
  }

  def createFuture(delay: Int): Future[Int] = Future {
    printMessage(delay, s"Before Thread.sleep(${delay})")
    Thread.sleep(delay)
    if (Random.nextBoolean) throw new RuntimeException("Dead!")
    printMessage(delay, s"After Thread.sleep(${delay})")
    delay
  }

  def main(a: Array[String]): Unit = {
    val DELAY_LIMIT = 1000

    printMessage(0, "a")
    val f1 = createFuture(Random.nextInt(DELAY_LIMIT))
    printMessage(0, "b")
    val f2 = createFuture(Random.nextInt(DELAY_LIMIT))
    printMessage(0, "c")

    val result = f1.flatMap(i => {
      printMessage(0, "f1.flatMap")
      f2.map(j => {
        printMessage(0, "f2.map")
       i + j})
    })

    for {
      v1 <- f1
      v2 <- f2
    } {
      println(s"v1 + v2 = ${v1 + v2}")
    }

    handleFuture(f1)
    handleFuture(f2)
    handleFuture(result)

    // As long as the main call stack remains in memory
    // the child processes in the Future objects will
    // complete.  The main Thread is being blocked during this
    // time.
    while (!f1.isCompleted && !f2.isCompleted) {
      Thread.sleep(DELAY_LIMIT * 2)
    }

    printMessage(0, "exit")

  }

  def handleFuture(f: Future[Int]): Unit = {
    f.onComplete {
      case Success(i) => println(s"Success: ${i}")
      case Failure(e) => println(s"Failure: ${e}")
    }
  }

}
