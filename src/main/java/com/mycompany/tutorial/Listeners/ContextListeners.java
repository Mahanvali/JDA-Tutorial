package com.mycompany.tutorial.Listeners;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ContextListeners extends ListenerAdapter {
    @Override
    public void onUserContextInteraction(UserContextInteractionEvent event){
        if(event.getName().equals("Report")){
            String targetUser = event.getTarget().getAsMention();
            String resondUser = event.getUser().getAsMention();
            TextChannel reportedChannel = event.getJDA().getTextChannelById("1113468093134557220");
            event.reply(targetUser + " has been reported! Thank you for reporting.").setEphemeral(true).queue();
            reportedChannel.sendMessage(targetUser + " has been reported by " + resondUser).queue();
        }
    }
}
