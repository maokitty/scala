case class  Vec(val x:Double,val y:Double){
 def +(that:Vec) = new Vec(this.x+that.x,this.y+that.y)
}
val v1=Vec(1.0,2.0)
val v2=Vec(3.0,4.0)
val v3=v1+v2
println(v3.x)
println(v3.y)
