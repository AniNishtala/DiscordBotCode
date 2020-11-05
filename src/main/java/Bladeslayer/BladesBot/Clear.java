package Bladeslayer.BladesBot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

import static net.dv8tion.jda.api.Permission.ADMINISTRATOR;

public class Clear extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if(event.getMember().hasPermission(ADMINISTRATOR))
        if(args[0].equalsIgnoreCase(Bot.prefix + "clear")) {
            if (args.length < 2)
            {
                //error
            }
            else {
                try {

                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getChannel().deleteMessages(messages).queue();
                } catch (IllegalArgumentException e)
                {

                    // Error

                }


            }
        }

    }

}
