//class can inherit from multiple traits but only one abstract class
//abstract class can have constructor parameters as well as type parameters ,Traints can hava
//only type parameter
abstract class AbsItreator{
  type T
	  def hasNext:Boolean
	  def next:T
}
class StringIterator(s:String)extends AbsItreator{
	type T=Char
		private var i=0
		def hasNext = i<s.length
		def next={
			val ch=s charAt i
				i += 1
				ch
		}
}
//Mixins
trait RichIterator extends AbsItreator{
	def foreach(f:T=>Unit):Unit = while(hasNext) f(next)
}

object StringIteratorTest extends App{
	//class can only has a superclass(extends) but many mixins(with)
	//set args(0) : run like scala MinxinExample.scala  "asd"
	class RichStringIter extends StringIterator(args(0)) with RichIterator
		val iter = new RichStringIter
		iter foreach println
}
