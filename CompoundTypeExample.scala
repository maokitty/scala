trait Cloneable extends java.lang.Cloneable
{
 override def clone():Cloneable = {
  super.clone().asInstanceOf[Cloneable]
 }
}
trait Restable{
 def rest:Unit
}
//parameter should be clone and rest,can use key with to achieve this
def cloneAndRest(obj:Cloneable with Restable):Cloneable={
 val cloned = obj.clone()
 obj.rest
 cloned
}
