package com.scala.jdbc

import scalikejdbc._

case class Employee(id: Int, name: String, age: Int, department: String, salary: Long)

object ScalikeJDBC {

  def main(args: Array[String]): Unit = {

    //解析应用程序的conf文件
    // DBs.setupAll()
    scalikejdbc.config.DBs.setupAll()

    //创建有三个Employee
    val em = new Employee(1, "XiaoMIn", 23, "DataCenter", 12000)

    val em1 = new Employee(2, "XiaoXiong", 23, "DataCenter", 42000)

    val em2 = new Employee(3, "XiaoHua", 23, "DataCenter", 23000)

    //将创建的Employee放入List
    val employeeList: List[Employee] = List(em, em1, em2)

    //增加数据

    println("增加新数据")

    println("增加新数据" + addDataAndbathchSave(employeeList))

    //

    var emp1 = selectData()

    for (emp <- emp1) {

      //println(emp)

      println("id:" + emp.id + "\tname:" + emp.name + "\tage:" + emp.age + "\tdepartment:" + emp.department + "\tsalary:" + emp.salary)

      if (emp.id == emp1.size) return

    }

  }

  //增加并保存数据
  def addDataAndbathchSave(employees: List[Employee]): Unit = {

    DB.localTx { implicit session =>

      for (emp <- employees) {
        SQL("insert into Employee(id,name,age,department,salary) values(?,?,?,?,?)")
          .bind(emp.id, emp.name, emp.age, emp.department, emp.salary).update().apply()
      }
    }

  }

  //根据ID删除Data
  def removeByID(id: Int): Unit = {

    DB.autoCommit { implicit session => {

      SQL("delete from Employee where is = ?").bind(id).update().apply()

    }

    }
  }

  //更新salary数据和部门数据通过id

  def updateSalaryByID(id: Int, salary: Long): Unit = {

    DB.autoCommit { implicit session => {

      SQL("UPDATE Employee SET salary=? WHERE id = ? ").bind(id, salary).update().apply()

    }
    }
  }

  //查找数据

  def selectData(): List[Employee] = {

    DB.readOnly { implicit session => {

      SQL("SELECT * FROM Employee").map(results => Employee(results.int("id"),
        results.string("name"), results.int("age"), results.string("department"),
        results.long("salary"))).list().apply()
    }

    }

  }

}
