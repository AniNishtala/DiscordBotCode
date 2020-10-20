package Bladeslayer.BladesBot;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter {

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        // Check that the emote matches                        // Make sure it's not the bot reacting
        //To add X reaction to every server remove if(event.getGuild().getId().equals("766360284754870363))
        if (event.getGuild().getId().equals("766360284754870363"))
        if (event.getReactionEmote().getName().equals("❌") && !event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
            // Fetch the channel's message history and get the message by ID that was reacted to
            event.getChannel().retrieveMessageById(event.getMessageId()).queue(msg -> {
                // Check if the reacting user is the message author
                if (event.getMember().getUser().equals(msg.getAuthor())) {
                    // Delete the message, much easier now that we've stored the message from earlier
                    msg.delete().queue();
                } else {
                    // Remove the reaction
                    event.getReaction().removeReaction().queue();
                }
            });
        }
    }
}
