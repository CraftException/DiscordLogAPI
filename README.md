# DiscordLog-API

A Discord Log API, which adapt a list of Messages into a HTML file.

## Features:
    - Message Building with Date, Bot-Badge and Profile-Picture
    - Embed-Builder
    - Adapter for JDA
    - Support for multiple Attachements

## In Planung:
    - Reaktionen auf Nachrichten
    - Antworten auf Nachrichten

# How to Use:
    
### Create a simple Message

    Message(
        "1234567890",  // Unique ID of the Message
        Author( // Message Author
            "CraftException",  //Username
            1,  //Tag
            "1234567891",  // Unique ID of the Author
            "https://craftexception.de/profil.png" //Avatar URL
        ),
        Date(),  // Date of the Message
        "Content",  // Content
        false,  // Is Author a Bot
        Arrays.asList() // Attachements
    )

### Create an author:

    Author( // Message Author
            "CraftException",  //Username
            1,  //Tag
            "1234567891",  // Unique ID of the Author
            "https://craftexception.de/profil.png" //Avatar URL
        ),

### Create attachements:

Simple Attachement-List with 2 Files

        Arrays.asList( // Attachements
            File("helloworld.png", "https://craftexception.de/profil.png"),
            File("moin.png", "https://craftexception.de/")
        )

### Create Embeds:

    Embed( //Content of this Message
            "#ff0000",  //Hex Color
            "Cooles Embed",  //Title
            "Hey ich bin ein Embed!",  //Description,
            "Lorem Ipsum dolor Sit amet",  //Footer
            "",  //Footer Image URL
            "https://discord.com/assets/41484d92c876f76b20c7f746221e8151.svg",  //Big Image URL
            Arrays.asList(
                Field(
                    "1. Field",  //Header
                    "Lorem Ipsum",  //Content
                    true //Is Stacked
                ),
                Field(
                    "2. Field",  //Header
                    "Lorem Ipsum",  //Content
                    false //Is Stacked
                ),
                Field(
                    "3. Field",  //Header
                    "Lorem Ipsum",  //Content
                    false //Is Stacked
                )
            ) //Fields
        ),  // Embed-Content,

### Create an embedded-Message

    EmbedMessage(
        "123456789101112",  // Unique ID of the Message
        Author( // Message Author
            "CraftException",  //Username
            1,  //Tag
            "1234567891",  // Unique ID of the Author
            "https://craftexception.de/profil.png" //Avatar URL
        ),
        Date(),  // Date of the Message
        embed, //Embed (see above)
        "Achtung! Jetzt folgt ein cooles Embed!",  //Content
        true,  // Is Author a Bot
        attachements // Attachements (see above)
    )

### Adapt JDA-Messages [_net.dv8tion.jda.core.entities.Message_] to Messages

    JDAAdapter.adaptMessages(messages)

### Build HTML Code from Message-List

    DiscordLogAPI.buildHTML(LogConfiguration("ExampleChannel"), messages)

## Full Example

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

This will produce the following Output:

<img src="https://i.imgur.com/iRNVZyn.png">