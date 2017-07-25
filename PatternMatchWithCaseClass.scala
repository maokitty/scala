//sealed means all subType must be in the same file
sealed abstract class Notification
case class Email(sender:String,title:String,body:String) extends Notification
case class SMS(caller:String,message:String) extends Notification
case class Voice(contactName:String,link:String) extends Notification

def showNotification(notification:Notification):String={
// _ in Email(sender,title,_) means ignore parameter body; _ in case means catch all
//s before "string" make it possible to parse $variable
//v:Voice is the same as SMS/Email
 notification match {
  case Email(sender,title,_) => s"You get an Emainl"
  case SMS(caller,message) => s"You get an SMS from $caller message is $message"
  case v:Voice => s"You get an Voice"
  case _ => s"You get others"
 }
}
//case class do not need key new any more
val someSMS = SMS("wangchun","hello")
val voice = Voice("li","ss")
println(showNotification(someSMS))
println(showNotification(voice))

def showImportantNotification(n:Notification,m:Seq[String]):String={
n match{
 case Email(sender,_,_) if m.contains(sender) => s"you get important Email from $sender "
 case aa => showNotification(aa)
}
}
val importName=Seq("wangchun")
val myEmail = Email("wangchun","hello","w")
println(showImportantNotification(myEmail,importName))
println(showImportantNotification(voice,importName))
