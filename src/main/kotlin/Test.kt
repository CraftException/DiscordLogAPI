import DiscordLogAPI.Author
import DiscordLogAPI.DiscordLogAPI
import DiscordLogAPI.DiscordLogAPI.buildHTML
import DiscordLogAPI.Embed.Embed
import DiscordLogAPI.Embed.EmbedMessage
import DiscordLogAPI.Embed.Field
import DiscordLogAPI.LogConfiguration
import DiscordLogAPI.Message
import java.util.*
import kotlin.collections.ArrayList

fun main () {

    val messages: ArrayList<Message> = ArrayList<Message>()
    val message1 = Message(
        "123456789101112",  // Unique ID of the Message
        Author( // Message Author
            "CraftException",  //Username
            1,  //Tag
            "1234567891",  // Unique ID of the Author
            "https://craftexception.de/profil.png" //Avatar URL
        ),
        Date(),  // Date of the Message
        "Hello Discord-API!",  // Content
        false,  // Is Author a Bot
        Arrays.asList() // Attachements
    )
    messages.add(message1)

    val message3: Message = EmbedMessage(
        "123456789101112",  // Unique ID of the Message
        Author( // Message Author
            "Master",  //Username
            1234,  //Tag
            "1234567891",  // Unique ID of the Author
            "https://esportsone.com/wp-content/uploads/2019/08/one_bot_icon.png" //Avatar URL
        ),
        Date(),  // Date of the Message
        Embed( //Content of this Message
            "#ff0000",  //Hex Color
            "Hello Embed",  //Title
            "Hey There, I'm an Embed!",  //Description,
            "Lorem Ipsum dolor Sit amet",  //Footer
            "",  //Footer Image URL
            "https://discord.com/assets/41484d92c876f76b20c7f746221e8151.svg",  //Big Image URL
            Arrays.asList(
                Field(
                    "1st Field",  //Header
                    "Lorem Ipsum",  //Content
                    true //Is Stacked
                ),
                Field(
                    "2nd Field",  //Header
                    "Lorem Ipsum",  //Content
                    false //Is Stacked
                ),
                Field(
                    "3rd Field",  //Header
                    "Lorem Ipsum",  //Content
                    false //Is Stacked
                )
            ) //Fields
        ),  // Embed-Content,
        "Achtung! Jetzt folgt ein cooles Embed!",  //Content
        true,  // Is Author a Bot
        Arrays.asList() // Attachements
    )

    messages.add(message3)

    print(DiscordLogAPI.buildHTML(LogConfiguration("ExampleChannel"), messages))

}