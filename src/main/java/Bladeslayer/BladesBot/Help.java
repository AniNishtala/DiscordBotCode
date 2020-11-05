package Bladeslayer.BladesBot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Help extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String library = "https://ci.dv8tion.net/job/JDA/javadoc/";

        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Bot.prefix + "help")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setDescription("List of Commands");
            info.setTitle("Blade's Bot");
            info.setColor(Color.red);
            info.addField("hi", "says Hi", false);
            info.addField("UwU", "Prints UwU", false);
            info.addField("specs", "Prints Blade's custom built pc specs", false);
            info.addField("ping ", "returns the ping" ,false);
            info.addField("dtr ", "Lists the players stats by giving their Steam id" ,false);
            info.setDescription("Dev: "+event.getGuild().getMemberById("394289036224626699").getAsMention());
            info.setDescription("Language: "+"[Java](" + library + ")");
            info.addField("Hosting Platform: Blade's Custom Built PC ", "The computer it is hosted on" ,false);
            info.setFooter("Created by Bladeslayer#3954", event.getMember().getUser().getAvatarUrl());
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();


        }
    }




        }


