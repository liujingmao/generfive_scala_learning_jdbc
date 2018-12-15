package com.scala.scala01


object scala01 {
  def main(args: Array[String]): Unit = {

    println(1.to(10))

    var ra = 1 to 10

    var ra2=ra.map(_*2)

    println(ra2)

    val arr = Array(1,2,3,4,5,6,7)

    //for(i<-arr) println(i)

    //until是取值左闭右开

    //for(i<- 0 until(arr.length+1)) println(i)

    //println(arr)

    //List的flatten可以将嵌套list和list嵌套字符串压平，与其说压平，我觉得将list求并集
    //更为确切
    val list1=List(1,2,3,4,5,6,7,8,9)

    //用5将list1分割两个List，5在前一个list

    val list3=list1.grouped(5).toList

    println(list3)

    val lst4 = list3.flatten

    println(lst4)

    val l1=List(1,2,3)

    val l2=List(3,4,5)

    val l3=List(l1,l2)

    val l4=l3.flatten

    println(l4)

    val l5=l4.map(x=>(x,1))

    println(l5)

    val l6=l5.groupBy(_._1)

    println(l6)

    //val l7=l6.mapValues(_.size)

    //println(l7)



    //println(l3)



    //println(list3)
    //val list2=List()


  }

}
