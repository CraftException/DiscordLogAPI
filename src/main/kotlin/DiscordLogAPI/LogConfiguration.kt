package DiscordLogAPI


class LogConfiguration(var channel: String) {
    var header = "Discord-Log"
    var icon = "https://images-eu.ssl-images-amazon.com/images/I/51lpm9SpsJL.png"
    fun buildHeader(): String {
        return "<div style='width:100%;background-color:#202325;border:2px solid #242425;padding:40px;font-family:\"Open Sans\";font-weight: bold;'>" +
                "<table><tr><td><img height='120px' width='120px' src='" + icon + "' style='margin-right:50px;'></td><td>" +
                "<h2 style='color:white'>" + header + "</h2>" +
                "<h4 style='color:white'>" + channel + "</h4>" +
                "</td></tr></table></div>"
    }
}