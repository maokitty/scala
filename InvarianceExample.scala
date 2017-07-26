abstract class Animal{
 def name:String
 }
 case class Dog(name:String) extends Animal
 case class Cat(name:String) extends Animal
class Container[A](value:A){
 private var _value:A=value
 def getValue:A=_value
 def setValue(value:A):Unit={_value=value}
}
val catC:Container[Cat] = new Container(Cat("F"))
//invariant will not support operation like this
val animal:Container[Animal] = catC
animal.setValue(Dog("Spot"))
val cat:Cat = catC.getValue


