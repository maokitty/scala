abstract class Animal{
 def name:String
}

abstract class Pet extends Animal{
}
class Cat extends Pet{
 override def name:String="Cat"
}
class Dog extends Pet{
 override def name:String="Dog"
}

class Lion extends Animal{
 override def name:String="Lion"
}
//p must be SubType of Pet
class PetContainer[P<:Pet](p:P){
 def pet:P=p
}
val dogCon = new PetContainer[Dog](new Dog)
val catCon = new PetContainer[Cat](new Cat)
//must be child of Pet
//val lionCon = new PetContainer[Lion](new Lion)

trait Node[+B]{
 def prepend[U >:B](elem:U):Unit
}

case class ListNode[+B](h:B,t:Node[B]) extends Node[B]{
 //lsp:while param should be more Contravariance,result should be Covariaance
 //def prepend(elem:B) = ListNode[B](elem,this) scala check this while compile
 //so when override the method of parents , ListNode.prepend's param blow here  should be parant of Node.prepend's param ,while Node is parant of ListNode [Contravariance]
 // in another way:prepend is a consumer(like set method),param should be a parant  according to PECS
 def prepend[U >:B](elem :U)=ListNode[U](elem,this)
 def head:B=h
 def tail = t
}
case class Nil[+B]()extends Node[B]{
 def prepend[U >:B](elem:U) = ListNode[U](elem,this)
}
trait Mammal
case class ASwallow() extends Mammal
case class ESwallow() extends Mammal
//ASwallow is child of Mammal,so ListNode[ASwallow] is a child of ListNode[Mammal] ,according to definition ListNode[+B](covariance)
val aList = ListNode[ASwallow] (ASwallow(),Nil())
val mList:Node[Mammal] = aList
mList.prepend(new ESwallow)

