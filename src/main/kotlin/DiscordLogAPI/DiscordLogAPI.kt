package DiscordLogAPI

import DiscordLogAPI.HTMLBuilder.MessageBuilder

object DiscordLogAPI {
    fun buildHTML(
        logConfiguration: LogConfiguration,
        messages: List<Message?>
    ): String {
        val start =
            logConfiguration.buildHeader() + "<div style='margin:0;width:100%;height:100%;position:absolute;background-color:#2C2F33'>"
        val end = "</div>"
        val messageContent = arrayOf("")
        messages.forEach { message ->
            messageContent[0] += MessageBuilder.buildMessage(message!!)
        }
        return "<html><head><title>Discord Log</title><script src='https://kit.fontawesome.com/a076d05399.js'></script></head><body style='margin:0;background-color:rgb(239, 239, 249);'>$start" + messageContent[0] + end + "</body></html>"
    }
}