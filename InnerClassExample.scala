class Graph{
 //nested class , path dependent
 class Node{
   var connectedNodes:List[Node] = Nil
   def connectTo(node:Node){
    if(connectedNodes.find(node.equals).isEmpty ){
      connectedNodes = node :: connectedNodes 
    }
   }
 }
 var nodes:List[Node] =Nil
 def newNode:Node={
  val res = new Node
  nodes = res :: nodes
  res
 }
}
val g1:Graph = new Graph
val n1:g1.Node =  g1.newNode
val n2:g1.Node = g1.newNode
val n3:g1.Node = g1.newNode

n1.connectTo(n2)
n2.connectTo(n3)

//val g3:Graph = new Graph
//val n4:g3.Node = g3.newNode
// type of n4 is g3.Node while n3 is g1.Node , g3.Node and g1.Node are different in scala
//n3.connectTo(n4)

//to fix syntax over here , definition of Graph  should be change by following way
class Graph2{
 class Node2{
   var connectedNodes2:List[Graph2#Node2] = Nil
   def connectTo2(node:Graph2#Node2){
     if(connectedNodes2.find(node.equals).isEmpty){
       connectedNodes2 = node :: connectedNodes2
     }
   }
 }
 var nodes:List[Node2] = Nil
 def newNode:Node2={
  var node = new Node2
  nodes = node :: nodes
  node
 }
}
val g21:Graph2 = new Graph2
val n21:g21.Node2 = g21.newNode
val g22:Graph2 = new Graph2
val n22:g22.Node2 = g22.newNode
n21.connectTo2(n22)


