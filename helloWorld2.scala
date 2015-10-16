//scalac helloWorld2.scala && scala -classpath . HelloWorld2 uno dos tres

object HelloWorld2 extends App {
	println("Que parezca que hago algo, con menos codigo:" + (args mkString ", "))
}