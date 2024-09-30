package com.mycompany.tutorial.Commands;


import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        //  Ping slash command
        Color embedColor = new Color(44, 45, 48);
        if(event.getName().equals("ping")){ 
            //  Add subcomamnd
            if(event.getSubcommandName().equals("add")){
               EmbedBuilder embedBuilder = new EmbedBuilder();
               embedBuilder.setTitle("Add initiated");
               embedBuilder.setDescription("This is a description");
               embedBuilder.setFooter("This is a simple JDA Bot", event.getJDA().getSelfUser().getDefaultAvatarUrl());
               embedBuilder.setColor(embedColor);
               event.replyEmbeds(embedBuilder.build()).queue();
            }
            // Remove subcommand
            if(event.getSubcommandName().equals("remove")){
                event.reply("Remove initiated").queue();
            }
        }
    }
}
