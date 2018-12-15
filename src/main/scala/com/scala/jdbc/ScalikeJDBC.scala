package com.scala.jdbc

import scalikejdbc._
import scalikejdbc.config._

case class Employee(id:Int,name:String,age:Int,department:String,Salary:Long)

object ScalikeJDBC {

  def main(args: Array[String]): Unit = {

    //
    scalikejdbc.config.DBs.setupAll()

    val em = new Employee(1,"XiaoMIn",23,"DataCenter",12000)

    val em1 = new Employee(2,"XiaoXiong",23,"DataCenter",42000)

    val em2 = new Employee(3,"XiaoHua",23,"DataCenter",23000)


    val employeeList:List[Employee]=List(em,em1,em2)



  }

}
