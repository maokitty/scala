// Start writing your ScalaFiddle code here
println("hello world")

val x:Int = 1+1
println(x)

println({
  val x=1+1
    //last expression in the block is the result of the overall block
      x+1
      })

//on the left '=' is funcname,between '=>' and '=' is parameter
// right of '=>' is expression involving parameters
	val addOne = (x:Int,y:Int) => x+y
println(addOne(1,2))

//def methodName parameter lists returnType body 
//in multi-line ,should be in block
def addThenMultiply(x:Int,y:Int)(multiplier:Int):Int = (x+y)*multiplier
 println(addThenMultiply(1,2)(3))

 //class className constructorParameters
 class Greeter(prefix:String,suffix:String){
	 //Unit means nothing to return(scala must hava some value to return)
	 def greet(name:String):Unit=
				println(prefix+name+suffix)
 }

val greeter = new Greeter("Hello,","!")
greeter.greet("scala developer")

//case classes immutable and compared by value;good for modeling immutable data
	case class Point(x:Int,y:Int)
	val point=Point(1,2)
val anotherPoint = Point(1,2)
	if(point == anotherPoint){
		println(point+" and "+anotherPoint+" are the same")
	}else{
		println(point+" and "+anotherPoint+" are different")
	}

//single instances of their own definitions
object IdFactory{
	private var counter = 0
		def create():Int = {
			counter +=1
				counter
		}
}
	val newId:Int = IdFactory.create()
	println(newId)
	val newerId:Int= IdFactory.create()
println(newerId)

	//traits uesd to share interfaces and fields between classes,Classes and objects
	//can extend traits but traits cannot be instantiated and have no parameters
	trait GreeterT{
		def greet(name:String):Unit = 
				       println("Hello,"+name+"!")
	}
class DefaultGreeter extends GreeterT

class CustomizableGreeter(prefix:String,postfix:String)extends GreeterT{
	override def greet(name:String):Unit = {
		println(prefix+name+postfix)
	}
}
val dGreeter = new DefaultGreeter()
	dGreeter.greet("scala developer")
	val customGreeter = new CustomizableGreeter("How are u,","?")
	customGreeter.greet("Scala devloper")

	//Any is supertype of all types,defins certain universal methods such as equals ,hashcode,toString
	val list:List[Any]=List(
			"a string",
			732,
			'c',
			true,
			()=>"an anonymous function returning a string"
			)
list.foreach(element => println(element))
