package Bladeslayer.BladesBot;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class GuildMemberLeave extends ListenerAdapter {

    String[] messages = {"[member] left, we're sorry to see you leaving."};
    public void onGuildMemberRemove(GuildMemberRemoveEvent event)
    {
        Random rand = new Random();
        int num = rand.nextInt(messages.length);
        EmbedBuilder join = new EmbedBuilder();
        join.setColor(Color.MAGENTA);
        join.setDescription(messages[num].replace("[member]" , event.getMember().getAsMention()));
        event.getGuild().getTextChannelsByName("general",true ).get(0).sendMessage(join.build()).queue();
        event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRolesByName("Member", true).get(0)).complete();
    }
}
