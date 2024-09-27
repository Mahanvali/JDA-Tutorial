package com.mycompany.tutorial.Commands;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlowmodeCommand extends ListenerAdapter {
    int slowmodeTime;
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        int slowmodeTime;
        if(event.getName().equals("slowmode")){
            String slowmodeTimeString = event.getOption("time").getAsString();
            TextChannel currentTextChannel = event.getChannel().asTextChannel();
            if(slowmodeTimeString.endsWith("h")){
                //  Remove the h from the string, and then parse the string to an int
                int hours = Integer.parseInt(slowmodeTimeString.substring(0, slowmodeTimeString.length() - 1));
                slowmodeTime = hours * 3600;
            } else if(slowmodeTimeString.endsWith("m")){
                 //  Remove the m from the string, and then parse the string to an int
                int minutes = Integer.parseInt(slowmodeTimeString.substring(0, slowmodeTimeString.length() - 1));
                slowmodeTime = minutes * 60;
            } else if(slowmodeTimeString.endsWith("s")){
                 //  Remove the s from the string, and then parse the string to an int
                int seconds = Integer.parseInt(slowmodeTimeString.substring(0, slowmodeTimeString.length() - 1));
                slowmodeTime = seconds;
            } else {
                event.reply("Please set a valid slowmode\nExample: /slowmode 1s").queue();
                return;
            }
             //  Set the channel slowmode to slowmodeTime
            currentTextChannel.getManager().setSlowmode(slowmodeTime).queue();
            event.reply("Successfully set the slowmode to " + slowmodeTimeString).queue();
        }
    }
}
