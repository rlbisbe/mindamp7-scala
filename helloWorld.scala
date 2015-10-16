//scalac helloWorld.scala && scala -classpath . HelloWorld uno dos tres

object HelloWorld {
	def main(args: Array[String]){
		println("Que parezca que hago algo:" + (args mkString ", "))
	}
}