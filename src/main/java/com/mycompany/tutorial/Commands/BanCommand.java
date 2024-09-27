package com.mycompany.tutorial.Commands;

import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BanCommand extends ListenerAdapter {
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        if(event.getName().equals("ban")){
            User targetUser = event.getOption("user").getAsUser();
            String reason = event.getOption("reason").getAsString();
            int deletionTimeFrame = event.getOption("deletiontime").getAsInt();

            if(deletionTimeFrame > 7){
                deletionTimeFrame = 7;
            }

            if(targetUser.getId().equals(event.getUser().getId())){
                event.reply("You can not ban yourself").queue();
                return;
            }

            if(targetUser.getId().equals(event.getJDA().getSelfUser().getId())){
                event.reply("You can not ban the bot").queue();
                return;
            }
            event.getGuild().ban(targetUser, deletionTimeFrame, TimeUnit.DAYS).reason(reason).queue();
            event.reply(targetUser.getAsMention() + " has been banned\n" + "Reason: " + reason).queue();
        }
    }
}
