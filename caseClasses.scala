//scalac caseClasses.scala && scala -classpath . CaseClassesTest


abstract class Employee
case class Manager(startYear: Int, direct: Array[Employee]) extends Employee
case class Dev(startYear: Int) extends Employee
case class Intern(stay: Int) extends Employee


object Payroll {
	def printSalary(employee: Employee) {
		val currentYeay = 2001
	    employee match {
	      case Intern(stay) =>
	        println(stay * 300)
	      case Dev(startYear) =>
	        println(1000 + (currentYeay - startYear) * 500)
	      case Manager(startYear, direct) =>
	        println(1000 + (currentYeay - startYear) * 500 + direct.length * 20) 
    	}	
  	}
}

object CaseClassesTest {
	def main(args: Array[String]){
		val dev = new Dev(1997)
		val intern = new Intern(4)
		val manager = new Manager(2001, Array(dev, intern))
		Payroll.printSalary(dev)
		Payroll.printSalary(intern)
		Payroll.printSalary(manager)
  	}
}