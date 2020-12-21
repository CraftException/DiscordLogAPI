package DiscordLogAPI

import DiscordLogAPI.LogConfiguration
import DiscordLogAPI.HTMLBuilder.MessageBuilder
import DiscordLogAPI.Author
import java.time.ZoneId
import DiscordLogAPI.JDAAdapter
import DiscordLogAPI.Embed.Embed
import DiscordLogAPI.Embed.EmbedMessage

class Author(var username: String, var tag: Int, var unique_id: String, var avatarURL: String)