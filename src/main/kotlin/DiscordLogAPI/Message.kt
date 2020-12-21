package DiscordLogAPI

import java.util.*

open class Message(var unique_id:String, var author:Author, var date:Date, var content:String, var bot:Boolean, var attachments:List<File>)