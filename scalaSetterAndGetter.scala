class Point{
	private var _x =0
		private var _y = 0
		private val bound =100

		def x=_x
		def x_=(newValue:Int):Unit = {
			if(newValue < bound) _x = newValue else printWarning
		}
	//sytax for getter
	def y = _y
		//sytax for setters : no space between 'y_' and '='
		def y_= (newValue:Int):Unit={
			if(newValue < bound) _y = newValue else printWarning
		}
	private def printWarning = println("WARN:Out of bounds")
}
val point1 = new Point
point1.x=99
//point1.y=101

class MyPoint(val x:Int,val y:Int){
	//constructor parameters with val and var are public.without are private ,visible only within the class
	//constructor without private ,scala will produce getter and setter automately
	//default setter can not be modified,we can change this like Point
}
val myPoint = new MyPoint(1,2)
	//myPoint.x = 3  val s are immutable ,so it's wrong
