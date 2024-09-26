package com.mycompany.tutorial.Commands;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class KickCommand extends ListenerAdapter {
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        //  Get the user and reason options
        User targetUser = event.getOption("user").getAsUser();
        String reason = event.getOption("reason").getAsString();
        //  If the slash command is the kick command
        if(event.getName().equals("kick")){
            //  Don't allow the user to kick themselves
            if(targetUser.getId().equals(event.getUser().getId())){
                event.reply("You can not kick yourself!").queue();
                return;
            }
            //  Don't allow the user to kick the bot
            if(targetUser.getId().equals(event.getJDA().getSelfUser().getId())){
                event.reply("You can not kick the bot!").queue();
                return;
            }
            //  Kicking the user
            event.getGuild().kick(targetUser).reason(reason).queue();
            event.reply(targetUser.getAsMention() + " has been kicked!\n Reason: " + reason).queue();
        }
    }
}
