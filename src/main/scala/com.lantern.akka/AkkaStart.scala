package com.lantern.akka

import scala.concurrent.Future

object AkkaStart {

  implicit val ec = scala.concurrent.ExecutionContext.global

  def main(a: Array[String]): Unit = {
    
    val f1 = Future[Int] {
      println("Hello")
      0
    }

    for {
      i <- f1
    } {
      println(s"got i $i")
    }


  }


}
