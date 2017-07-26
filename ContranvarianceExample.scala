abstract class Printer[-A]{
 def print(value:A):Unit
}
class AnimalPrinter extends Printer[Animal]{
 def print(animal:Animal):Unit= println("name "+animal.name)
}
class CatPrinter extends Printer[Cat] {
 def print(cat:Cat):Unit = println("cat name "+cat.name)
}
abstract class Animal{
 def name:String
 }
 case class Dog(name:String) extends Animal
 case class Cat(name:String) extends Animal

object ContranvarianceTest extends App{
 val cat:Cat = Cat("aa")
 def printCat(printer:Printer[Cat]):Unit = {
   printer.print(cat)
 }

 val catPrinter: Printer[Cat] = new CatPrinter
   val animalPrinter: Printer[Animal] = new AnimalPrinter
     printCat(catPrinter)
       printCat(animalPrinter)
}
