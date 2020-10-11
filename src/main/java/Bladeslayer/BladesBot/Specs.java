package Bladeslayer.BladesBot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Specs extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Bot.prefix + "specs")) {
            EmbedBuilder builder = new EmbedBuilder();
            builder.setDescription("PC specs");
            builder.setTitle("Blade's Bot");
            builder.setColor(Color.green);
            builder.addField("MotherBoard" , "Asus X470-F", false);
            builder.addField("RAM" , "2x8 Corsair Vengeance 3200MHZ RGB", false);
            builder.addField("CPU" , "AMD Ryzen 2600X ", false);
            builder.addField("GPU" , "MSI GTX 1070Ti Duke 8GB VRAM", false);
            builder.addField("PSU" , "EVGA 800W Gold 80+", false);
            builder.addField("Fans" , "Corsair 3 ll120mm + 2 140mm stock fans and 1 120mm stock fans", false);
            builder.addField("Keyboard" , "Corsair K95 RGB Platinum", false);
            builder.addField("Mouse" , "Logitech G502 Proteus Spectrum", false);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(builder.build()).queue();

        }
    }
}
