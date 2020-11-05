package Bladeslayer.BladesBot;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import static net.dv8tion.jda.api.Permission.ADMINISTRATOR;

public class Mute extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if(event.getMember().hasPermission(ADMINISTRATOR))
        if(args[0].equalsIgnoreCase(Bot.prefix + "mute")) {
            if (args.length > 1 && args.length < 3) {
                Member member = event.getMessage().getMentionedMembers().get(0);
                Role role = event.getGuild().getRoleById("766381329038180392");
                if(!member.getRoles().contains(role)){
                    //mute user
                    event.getChannel().sendMessage("Muted "+args[1] + ".").queue();
                    event.getGuild().addRoleToMember(member, role).complete();

                }
                else
                {
                    //unmute user
                    event.getChannel().sendMessage("Unmuted "+args[1] + ".").queue();
                    event.getGuild().removeRoleFromMember(member, role).queue();

                }
            } else if (args.length == 3)
            {
                Member member = event.getMessage().getMentionedMembers().get(0);
                Role role = event.getGuild().getRoleById("766381329038180392");
                event.getChannel().sendMessage("Muted "+args[1] + " for "+args[2] + " seconds.").queue();
                event.getGuild().addRoleToMember(member, role).complete();
                //unmute after some time
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {

                            @Override
                            public void run() {
                                event.getChannel().sendMessage("Unmuted "+args[1] + ".").queue();
                                event.getGuild().removeRoleFromMember(member, role).queue();
                            }
                        },
                        Integer.parseInt(args[2]) * 1000

                );

            }
            else
            {
                event.getChannel().sendMessage("Incorrect Syntax. Use a!mute  [user mention] [time optional]").queue();
            }
        }
    }
}
