package DiscordLogAPI.Embed

import DiscordLogAPI.Author
import DiscordLogAPI.Embed.Embed

class Embed(
    hexColor: String,
    title: String,
    var description: String,
    footer: String,
    footerImageURL: String,
    thumbnailURL: String,
    fields: List<Field>
) {
    var hexColor: String? = null
    var title: String
    var footer: String
    var fields: List<Field>
    var thumbnailURL: String
    var footerImageURL: String

    init {
        if (hexColor.startsWith("#")) {
            this.hexColor = hexColor
        } else {
            this.hexColor = "#$hexColor"
        }
        this.footer = footer
        this.footerImageURL = footerImageURL
        this.title = title
        this.thumbnailURL = thumbnailURL
        this.fields = fields
    }
}