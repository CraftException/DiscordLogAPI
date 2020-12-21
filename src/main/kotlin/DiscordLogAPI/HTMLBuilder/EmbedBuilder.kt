package DiscordLogAPI.HTMLBuilder

import DiscordLogAPI.Embed.Embed
import DiscordLogAPI.Embed.Field
import java.util.function.Consumer

object EmbedBuilder {
    fun buildEmbed(embed: Embed): String {
        val start =
            "<div style='background-color: #2F3136; margin-top:5px; border-left: 3px solid " + embed.hexColor + ";position:relative;padding-right:150px;border-radius:5px'>"
        val thumbnail =
            "<img style='position:absolute;top:15px;right:15px;max-width:150px;max-height:150px;' src='" + embed.thumbnailURL + "'>"
        val end = "</div>"
        return start + thumbnail + buildContent(embed) + end
    }

    private fun buildContent(embed: Embed): String {
        val start = "<div style='padding:15px'>"
        val end = "</div>"
        val contentTitle =
            "<span style='color:rgb(239, 239, 249);font-family:\"Open Sans\";font-weight: bold;font-size: 14px;'>" + embed.title + "</span><br>"
        val contentDescription =
            "<span style='color:rgb(192, 186, 190);font-family:\"Open Sans\";font-weight: bold;font-size: 12px;margin-bottom:5px;'>" + embed.description + "</span><br>"
        val contentFooter =
            "<span style='margin-right:20px;font-size: 12px;font-weight: bold;font-family:\"Open Sans\";'>" + embed.footer + "<img src='" + embed.footerImageURL + "' style='margin-left:5px;' width='20px' height='20px'></span><br>"
        val content = contentTitle + contentDescription
        return start + content + buildFields(embed) + contentFooter + end
    }

    private fun buildFields(embed: Embed): String {
        val start = "<table>"
        val end = "</table>"
        val fieldsHTML = arrayOf(start)
        embed.fields.forEach(Consumer { e: Field ->
            if (e.stacked) {
                fieldsHTML[0] += "<tr>"
            }
            fieldsHTML[0] += "<td>"
            fieldsHTML[0] += "<span style='color:white;font-family:\"Open Sans\";font-weight: bold;font-size: 14px;'>" + e.header + "</span><br>"
            fieldsHTML[0] += "<span style='color:rgb(192, 186, 190);font-family:\"Open Sans\";font-weight: bold;font-size: 13px;'>" + e.content + "</span><br>"
            fieldsHTML[0] += "</td>"
            if (e.stacked) {
                fieldsHTML[0] += "</tr>"
            }
        })
        fieldsHTML[0] = fieldsHTML[0] + end
        return fieldsHTML[0]
    }
}