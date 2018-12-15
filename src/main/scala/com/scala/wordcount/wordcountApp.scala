package com.scala.wordcount

object wordcountApp {

  def main(args: Array[String]): Unit = {

    //

    val wordlist= List("hello scala","hello word","scala word","apple banana","spark scala")

   //第一种方法

    val wc=wordlist.flatMap(_.split(" "))
                    .map((_,1))
                    .groupBy(_._1)
                    .mapValues(_.size)
                    .toList.sortBy(_._2).reverse

    for(ele<-wc) println(ele)

    //第二种方法 flatMap运行结果与map().flatten.toList结果一样

    val wc1 = wordlist.map(_.split(" ")).flatten.toList

    val wc2 = wordlist.flatMap(_.split(" "))
                        .map((_,1))
                        .groupBy(_._1)
                        .map(t=>(t._1,t._2.size))
                        .toList.sortBy(_._2)
                        .reverse

    //println("***************************")

    //for(ele<-wc1) println(ele)

    println("***************************")

    for(e<-wc2) println(e)


    println("***************************")

    //第三种方法


    val wc3 = wordlist.flatMap(_.split(" "))
                      .map((_,1))
                      .groupBy(_._1)
                      .mapValues(_.foldLeft(0)(_+_._2))
                      .toList.sortBy(_._2).reverse

    for(e<-wc3) println(e)


  }

}
