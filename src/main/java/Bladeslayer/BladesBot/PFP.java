package Bladeslayer.BladesBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;

public class PFP extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args[0].equalsIgnoreCase(Bot.prefix + "pfp"))
        {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setColor(Color.YELLOW);
            embedBuilder.setDescription("Profile Picture");
            embedBuilder.addField("Profile Picture of "+event.getMember().getUser(), event.getMember().getUser().getAsMention(), false);
            embedBuilder.build();
        }
    }
}
