abstract class Animal{
 def name:String
}
case class Dog(name:String) extends Animal
case class Cat(name:String) extends Animal

//change object to class would not be work
//The Scala standard library has a generic immutable sealed abstract class List[+A] so list would be covariance in default
object CoVarianceTest extends App{
  def printNames(an:List[Animal]):Unit={
   an.foreach{a=>println(a.name)}
  }
  //covariant :if cat is child of animal then List[Cat] would be child of List[Animal]
  val cats:List[Cat] = List(new Cat("aa"),new Cat("bb"))
  printNames(cats)
}
