package com.mycompany.tutorial;

import java.util.EnumSet;

import com.mycompany.tutorial.Commands.BanCommand;
import com.mycompany.tutorial.Commands.KickCommand;
import com.mycompany.tutorial.Commands.ModalCommand;
import com.mycompany.tutorial.Commands.PingCommand;
import com.mycompany.tutorial.Commands.SlowmodeCommand;
import com.mycompany.tutorial.Listeners.ButtonInteractionListener;
import com.mycompany.tutorial.Listeners.ContextListeners;
import com.mycompany.tutorial.Listeners.MessageListener;
import com.mycompany.tutorial.Listeners.ModalInteractionListener;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.internal.entities.PermissionOverrideImpl;

public class App 
{
    public static void main( String[] args )
    {
        JDABuilder jdaBuilder = JDABuilder.createDefault(args[0], EnumSet.of(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT))
            .addEventListeners(new MessageListener(), new ButtonInteractionListener(), new PingCommand(), new ModalCommand(), new ContextListeners(), new ModalInteractionListener(), new KickCommand(), new BanCommand() , new SlowmodeCommand());
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
            Commands.context(Command.Type.USER, "Report"),
            Commands.slash("modal", "Simple modal popup"),
            Commands.slash("kick", "Kick a user!")
                .addOption(OptionType.USER, "user", "The user to kick", true)
                .addOption(OptionType.STRING, "reason", "The reason for kicking the user", true)
                .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.KICK_MEMBERS)),
            Commands.slash("ban", "Ban a user")
                .addOption(OptionType.USER, "user", "The user to ban", true)
                .addOption(OptionType.STRING, "reason", "Reason for banning the user", true)
                .addOption(OptionType.INTEGER, "deletiontime", "The time frame to delete the user's message from", true)
                .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.BAN_MEMBERS)),
            Commands.slash("slowmode", "Set a slowmode for the current channel")
                .addOption(OptionType.STRING, "time", "The amount of time to set the slowmode (s,m,h)", true)
                .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.MANAGE_CHANNEL))
        ).queue();
    }
}
