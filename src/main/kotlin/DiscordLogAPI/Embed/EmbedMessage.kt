package DiscordLogAPI.Embed

import DiscordLogAPI.Author
import DiscordLogAPI.Embed.Embed
import DiscordLogAPI.File
import DiscordLogAPI.Message
import java.util.*

class EmbedMessage(
    unique_id: String?,
    author: Author?,
    date: Date?,
    var embed: Embed,
    content: String?,
    bot: Boolean,
    attachments: List<File?>?
) : Message(
    unique_id!!, author!!, date!!, content!!, bot, attachments!! as List<File>
)