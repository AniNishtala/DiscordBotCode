package Bladeslayer.BladesBot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        //To add X reaction to every server remove if(event.getGuild().getId().equals("766360284754870363))
        if (event.getGuild().getId().equals("766360284754870363")) {
            event.getMessage().addReaction("❌").queue();
        } else {
            return;
        }
    }
}
