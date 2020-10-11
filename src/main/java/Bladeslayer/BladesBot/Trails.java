package Bladeslayer.BladesBot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Trails extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Bot.prefix + "trails")) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("It's spelled trials idiot").queue();
        }
    }
}
