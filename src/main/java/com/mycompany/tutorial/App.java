package com.mycompany.tutorial;

import java.util.EnumSet;

import com.mycompany.tutorial.Commands.PingCommand;
import com.mycompany.tutorial.Listeners.ButtonInteractionListener;
import com.mycompany.tutorial.Listeners.ContextListeners;
import com.mycompany.tutorial.Listeners.MessageListener;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class App 
{
    public static void main( String[] args )
    {
        JDABuilder jdaBuilder = JDABuilder.createDefault(args[0], EnumSet.of(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT))
            .addEventListeners(new MessageListener(), new ButtonInteractionListener(), new PingCommand(), new ContextListeners());
        JDA jda = jdaBuilder.build();

        jda.updateCommands().addCommands(
            //  Create a new slash command, ping.
            Commands.slash("ping", "A say command")
                //  Add subcomamnds
                .addSubcommands(
                new SubcommandData("add", "Add I guess"),
                new SubcommandData("remove", "Remove I guess")
                ),
                // Options
                // .addOption(OptionType.String, "message", "message to say", true),
            //  Report Context menu
            Commands.context(Command.Type.USER, "Report")
        ).queue();
    }
}
