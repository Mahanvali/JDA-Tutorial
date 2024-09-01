package com.mycompany.tutorial;

import java.util.EnumSet;

import com.mycompany.tutorial.Commands.PingCommand;
import com.mycompany.tutorial.Listeners.ButtonInteractionListener;
import com.mycompany.tutorial.Listeners.ContextListeners;
import com.mycompany.tutorial.Listeners.MessageListener;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class App 
{
    public static void main( String[] args )
    {
        JDABuilder jdaBuilder = JDABuilder.createDefault(args[0], EnumSet.of(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT))
            .addEventListeners(new MessageListener(), new ButtonInteractionListener(), new PingCommand(), new ContextListeners());
        JDA jda = jdaBuilder.build();

        jda.updateCommands().addCommands(
            Commands.slash("ping", "A simple ping command!"),
            Commands.context(Command.Type.USER, "Report")
        ).queue();
    }
}
