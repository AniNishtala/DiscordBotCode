package Bladeslayer.BladesBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Ping extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args[0].equalsIgnoreCase(Bot.prefix + "ping"))
        {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setDescription("🏓 Pong!");
            long num = event.getJDA().getGatewayPing();
            double cpuload = getCPULoad();
            String ramusage = getRAMUsage();
            embed.addField("Latency", num + "ms", true);
            embed.addField("🤖 Hardware", ""+cpuload, true);
            embed.addField("Cores","6 cores",true);
            embed.addField("RAM", ramusage, true);
            embed.setColor(Color.YELLOW);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(embed.build()).queue();
        }
    }
    public double getCPULoad() {
        try {
            OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
            return osBean.getSystemLoadAverage();
        } catch (Exception e) {
            return 0.0;
        }
    }
    public String getRAMUsage() {
        try {
            Runtime runtime = Runtime.getRuntime();
            long allocatedMemory = runtime.totalMemory();
            long freeMemory = runtime.freeMemory();
            return String.valueOf((allocatedMemory - freeMemory) / 1000 / 1000);
        } catch (Exception e) {
            return "There was an error while attempting to collect ram usage!";
        }
    }
}
