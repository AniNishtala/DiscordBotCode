package Bladeslayer.BladesBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;
import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter {

    String[] messages = {"A wild [member] appeared."};
    public void onGuildMemberJoin(GuildMemberJoinEvent event)
    {
        Random rand = new Random();
        int num = rand.nextInt(messages.length);
        EmbedBuilder join = new EmbedBuilder();
        join.setColor(Color.cyan);
        join.setDescription(messages[num].replace("[member]" , event.getMember().getAsMention()));
        event.getGuild().getTextChannelsByName("welcome",true ).get(0).sendMessage(join.build()).queue();
        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRolesByName("Member", true).get(0)).complete();

    }
}
