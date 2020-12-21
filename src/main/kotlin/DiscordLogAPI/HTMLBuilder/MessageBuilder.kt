package DiscordLogAPI.HTMLBuilder

import java.text.SimpleDateFormat
import DiscordLogAPI.Embed.EmbedMessage
import DiscordLogAPI.File
import DiscordLogAPI.Message
import java.util.function.Consumer

object MessageBuilder {
    fun buildMessage(message: Message): String {
        val start = "<div style='margin:15px;'>"
        var content =
            "<table><tr><td><img style='vertical-align: text-top;' src='" + message.author.avatarURL + "' width='64px' height='64px'></td><td>"
        val dateFormat = SimpleDateFormat("dd.MM.yy HH:mm:SS")
        content += "<span style='color:rgb(239, 239, 249);font-family:\"Open Sans\";font-weight: bold;font-size: 14px;'>" + message.author.username + "</span><span style='color:rgb(239, 239, 249);font-family:\"Open Sans\";font-weight: bold;font-size: 11px;margin-left:7px;'>" + dateFormat.format(
            message.date
        ) + "</span>"
        if (message.bot) {
            content += "<span style='margin-left:5px;border-radius:5px;background-color:#7289DA;font-family:\"Open Sans\";font-size:10px;padding:2px;font-weight:bold;color:white;'>BOT</span>"
        }
        if (message is EmbedMessage) {
            content += "<br><span style='color:rgb(192, 186, 190);font-family:\"Open Sans\";font-weight: bold;font-size: 12px;'>" + message.content + "</span>"
            content += "<span style='color:rgb(192, 186, 190);font-family:\"Open Sans\";font-weight: bold;font-size: 12px;'>" + EmbedBuilder.buildEmbed(
                message.embed
            ) + "</span>"
        } else {
            content += "<br><span style='color:rgb(192, 186, 190);font-family:\"Open Sans\";font-weight: bold;font-size: 12px;'>" + message.content + "</span>"
        }
        content += buildAttachements(message.attachments)
        content += "</td></tr></table>"
        val end = "</div>"
        return start + content + end
    }

    private fun buildAttachements(attachements: List<File>): String {
        val attachementString = arrayOf("")
        attachements.forEach(Consumer { attachement: File ->
            if (attachement.url.contains(".png") || attachement.url.contains(".jpg")) {
                attachementString[0] += "<br><img style='margin:25px;max-width:256px;max-height:256px;' src='" + attachement.url + "'>"
            } else {
                attachementString[0] += "<br><div style='font-family:\"Open Sans\";font-size:14px;padding:10px;border-radius:8px;background-color:#202325;border:2px solid #242425;margin:15px;'><i class='fa fa-download' style='color:white;margin-right:10px;' aria-hidden='true'></i><a style='text-decoration:none;color:white;' href='" + attachement.url + "'>" + attachement.fileName + "</a>"
            }
        })
        return attachementString[0]
    }
}