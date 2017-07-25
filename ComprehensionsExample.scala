case class User(val name:String,val age:Int)

val userBase = List(new User("Travis",28),new User("Keely",33),new User("Jennifer",44),new User("Dennis",23))
//yield user.name meas add this to a list , yield statement actually creates a List
val twentySomthings = for (user <- userBase if(user.age >=20 && user.age <30)) yield user.name
twentySomthings.foreach(name => println(name))
