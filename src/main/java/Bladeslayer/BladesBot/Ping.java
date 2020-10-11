package Bladeslayer.BladesBot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args[0].equalsIgnoreCase(Bot.prefix + "ping"))
        {
            long num = event.getJDA().getGatewayPing();
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("🏓 Pong! The latency is "+num + " MS").queue();
        }
    }
}
