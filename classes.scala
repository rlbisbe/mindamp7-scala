//scalac classes.scala && scala -classpath . MindCamp

class Speaker(name: String, age: Int){

	def speak(callback:() => String): String = {
		name + " is speaking" + ", public says " + callback()
	}

	def walk() {
		println("No return parameter")
	}	
}

object MindCamp extends App{

	def boo(): String = {
		"booo"
	}

	def applause(): String = {
		"applause"
	}

	

	var superman = new Speaker("Clark Kent", 34)
	val batman = new Speaker("Bruce Wayne", 42)
	
	println(batman.speak(boo))
	println(superman.speak(applause))

	//Invalid type
	/*
	def indiferent() {
		"meh"
	}
	*/
	//println(superman.speak(indiferent))

	
	//This should crash
	//batman = new Speaker("Robin", 23)

	//This should not
	//superman = new Speaker("Kal-el", 70)

	//This will crash with current name, set val
	//println("Batman is: " + batman.name)

}