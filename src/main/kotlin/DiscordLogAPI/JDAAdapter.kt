package DiscordLogAPI

import DiscordLogAPI.Embed.Embed
import DiscordLogAPI.Embed.EmbedMessage
import DiscordLogAPI.Embed.Field
import java.lang.String
import java.util.*
import net.dv8tion.jda.api.entities.MessageEmbed
import java.time.ZoneId

object JDAAdapter {
    fun adaptMessages(messages: List<net.dv8tion.jda.api.entities.Message>): List<Message> {
        val message: MutableList<Message> = ArrayList<Message>()
        messages.forEach { message1: net.dv8tion.jda.api.entities.Message ->
            if (message1.embeds.size === 0) {
                message.add(
                    Message(
                        message1.id,
                        Author(
                            message1.author.name,
                            1,
                            message1.author.id,
                            message1.author.avatarUrl!!
                        ),
                        Date.from(
                            message1.timeCreated.toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant()
                        ),
                        message1.getContentDisplay(),
                        message1.getAuthor().isBot(),
                        adaptAttachements(message1.getAttachments())
                    )
                )
            } else {
                val fields: MutableList<Field> = ArrayList<Field>()
                message1.embeds[0].fields.forEach { field -> fields.add(getField(field)) }
                val embed = Embed(String.valueOf(message1.embeds[0].colorRaw), "", "", "", "", "", fields)
                if (message1.embeds[0].title != null) {
                    embed.title = message1.embeds[0].title!!
                }
                if (message1.embeds[0].description != null) {
                    embed.description = message1.embeds[0].description!!
                }
                if (message1.embeds[0].footer!!.text!! != null) {
                    embed.footer = message1.embeds[0].footer!!.text!!
                }
                if (message1.embeds[0].url != null) {
                    embed.thumbnailURL = message1.embeds[0].image!!.url!!
                }
                if (message1.embeds[0].footer!!.iconUrl!! != null) {
                    embed.footerImageURL = message1.embeds[0].footer!!.iconUrl!!
                }
                message.add(
                    EmbedMessage(
                        message1.getId(),
                        Author(
                            message1.getAuthor().getName(),
                            1,
                            message1.getAuthor().getId(),
                            message1.author.avatarUrl!!
                        ),
                        Date.from(
                            message1.timeCreated.toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant()
                        ),
                        embed,
                        message1.getContentDisplay(),
                        message1.getAuthor().isBot(),
                        adaptAttachements(message1.getAttachments())
                    )
                )
            }
        }
        return message
    }

    private fun getField(field: MessageEmbed.Field): Field {
        return Field(field.name!!, field.value!!, true)
    }

    private fun adaptAttachements(attachments: List<net.dv8tion.jda.api.entities.Message.Attachment>): List<File> {
        val files: MutableList<File> = ArrayList<File>()
        attachments.forEach { attachment: net.dv8tion.jda.api.entities.Message.Attachment ->
            files.add(
                File(
                    attachment.fileName,
                    attachment.url
                )
            )
        }
        return files
    }
}