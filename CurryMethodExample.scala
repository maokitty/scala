object MyObject extends App{
 def filter(xs:List[Int],p:Int=>Boolean):List[Int]={
   //p is a function,Int means type of parameter,Boolean means return value type
   //xs.tail return the element except the first
   //xs.head:: filter(xs.tail,p) means add the xs.head to the head of filter results
   //List is  mutable, function :: will generate a new List
   if(xs.isEmpty) xs
   else if(p(xs.head)) xs.head:: filter(xs.tail,p)
   else filter(xs.tail,p)
 }
 //modN will be turn into modN(n:Int)=(x:Int)=>((x%n)==0) , modN(n:Int) will return a anonymous function
 //so modN(2) will return a funtion (x:Int)=>((x%2)==0),which is p over here
 def modN(n:Int)(x:Int) = ((x%n)==0)
 val num = List(1,2,3,4,5,6,7,8)
 println(filter(num,modN(2)))
 println(filter(num,modN(3)))
}
