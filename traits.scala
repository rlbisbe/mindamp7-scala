//scalac traits.scala && scala -classpath . EmployeeTest

abstract class Employee {
	def salary: Int
}

trait InOffice {
	def desk: String
}

trait Remote {
	def location: String
}

trait Temporary {
	def startDate: Int
	def stay: Int
	def endDate(): Int = (startDate + stay) % 12
}

trait Authority {
	def directReports: Array[Employee]
	def hasDirectReports() :Boolean = directReports.length != 0
}

class Intern (
	val salary: Int, 
	val desk: String, 
	val startDate: Int, 
	val stay: Int = 6) 
	extends Employee with InOffice with Temporary {}

class Developer (
	val salary: Int, 
	val desk: String) 
	extends Employee with InOffice {}

class Manager (
	val salary: Int, 
	val location: String, 
	val directReports: Array[Employee]) 
	extends Employee with Remote with Authority {}

class Consultant (
	val salary: Int, 
	val location: String,
 	val directReports: Array[Employee]) 
	extends Employee with Authority {}

object EmployeeTest extends App {
	val dev = new Developer(123456, "A1234")
	val intern = new Intern(1234, "C1234", 2)
	val manager = new Manager(123456, "Chicago", Array(dev, intern))
	println(dev.salary)
	println(dev.desk)
	println(manager.hasDirectReports())
	println(manager.location)
	println(intern.endDate())
}