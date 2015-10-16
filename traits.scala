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

class Intern (salary_param: Int, desk_param: String, startDate_param: Int) 
	extends Employee with InOffice with Temporary {
	val salary = salary_param
	val desk = desk_param
	val stay = 6
	val startDate = startDate_param
}

class Developer (salary_param: Int, desk_param: String) 
	extends Employee with InOffice {
	val salary = salary_param
	val desk = desk_param
}

class Manager (salary_param: Int, location_param: String, reports: Array[Employee]) 
	extends Employee with Remote with Authority {
	val salary = salary_param
	val location = location_param
	val directReports = reports
}

/*
class Consultant (salary_param: Int, location_param: String, reports: Array[Employee]) 
	extends Employee with Authority {
	val salary = salary_param
}
*/

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