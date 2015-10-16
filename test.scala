//scalac test.scala && scala -classpath . ScalaTest

object ScalaTest {

	def assert(expected: Int, actual: Int){
    	if(expected == actual) {
			println("OK");
		}
		else {
			println("Error, expected: " + expected + " actual: "+ actual);
		}
	}

	def main(args: Array[String]){
		assert(0,0);
		assert(0,1);
	}
}