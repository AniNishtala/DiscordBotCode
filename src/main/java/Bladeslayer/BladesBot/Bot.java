package Bladeslayer.BladesBot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class Bot {

    public static String prefix = "a!";
    
    //Main Method

    public static void main(String[] args) throws LoginException {
        String token = "BotToken";
        //Replace BotToken with ur actual Token
        JDABuilder jda = JDABuilder.createDefault(token);
        jda.setStatus(OnlineStatus.DO_NOT_DISTURB);
        jda.enableIntents(GatewayIntent.GUILD_MEMBERS);
        jda.setActivity(Activity.playing("Destiny 2 | a!help"));
        // Replace Destiny 2 with anything game u want. 
        // jda.setActivity(Activity.watching("Watching twitch.tv/YourChannelName | a!help")); and remove jda.setActivity(Activity.playing("Destiny 2 | a!help"));
        jda.addEventListeners(new PFP(),new Mute(), new Clear(), new GuildMessageReactionAdd(),new GuildMessageReceived(), new GuildMemberJoin() , new Trails(), new Hi(), new UwU(), new Specs(), new GuildMemberLeave(), new Ping(), new Help());
        jda.setMemberCachePolicy(MemberCachePolicy.ALL);
        jda.build();


    }

}
