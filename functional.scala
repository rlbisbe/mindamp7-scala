//scalac functional.scala && scala -classpath . Functional
import scala.language.postfixOps
import scala.runtime.ScalaRunTime._

object Functional {

	def isPair(number: Int) = number % 2 == 0

	def sumPairsIter(start: Int, end: Int): Int = { 
		var i = start
		var acc = 0
		while (i <= end) {
			if (isPair(i)) acc += i
			i += 1
		}
		acc 
	}

	def sumPairsFunctional(start: Int, end: Int) =
		(start to end by 1 filter isPair).reduceLeft[Int](_+_)


	def sortIter(xs: Array[Int]): Array[Int] = { 

		def swap(i: Int, j: Int) {
			val t = xs(i); xs(i) = xs(j); xs(j) = t 
		}

		def sort1(l: Int, r: Int) { 
			val pivot = xs((l + r) / 2) 
			var i = l; var j = r
			while (i <= j) {
				while (xs(i) < pivot) i += 1 
				while (xs(j) > pivot) j -= 1 
				if (i <= j) {
					swap(i, j)
					i += 1
					j -= 1
				}
			} 
	
			if (l < j) sort1(l, j)
			if (j < r) sort1(i, r)
		}
		
		sort1(0, xs.length - 1)
		xs
	}
	
	def sortFunctional(xs: Array[Int]): Array[Int] = { 
		if (xs.length <= 1) xs
		else {
			val pivot = xs(xs.length / 2) 
			Array.concat(
						sortFunctional(xs filter (pivot >)), 
						     xs filter (pivot ==), 
						sortFunctional(xs filter (pivot <)))
		} 
	}

	def main(args: Array[String]){
		println(sumPairsIter(1, 10))
		println(sumPairsFunctional(1, 10))

		println(stringOf(sortIter(Array(2,5,4,3,1))))
		println(stringOf(sortFunctional(Array(2,5,4,3,1))))
	}
}
