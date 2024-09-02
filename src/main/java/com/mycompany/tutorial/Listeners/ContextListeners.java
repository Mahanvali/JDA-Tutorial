package com.mycompany.tutorial.Listeners;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ContextListeners extends ListenerAdapter {
    @Override
    public void onUserContextInteraction(UserContextInteractionEvent event){
        if(event.getName().equals("Report")){
            //  Get the targetUser (the user reported)
            String targetUser = event.getTarget().getAsMention();
            // Get the respondUser (the user who has reported the targetUser)
            String resondUser = event.getUser().getAsMention();
            //  Declare a TextChannel by ID
            TextChannel reportedChannel = event.getJDA().getTextChannelById("1113468093134557220");
            //  Tell the respondUser that the targetUser has been reported
            event.reply(targetUser + " has been reported! Thank you for reporting.").setEphemeral(true).queue();
            // Send the a message to reportedChannel
            reportedChannel.sendMessage(targetUser + " has been reported by " + resondUser).queue();
        }
    }
}
