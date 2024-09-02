package com.mycompany.tutorial.Commands;


import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        //  Ping slash command
        if(event.getName().equals("ping")){ 
            //  Add subcomamnd
            if(event.getSubcommandName().equals("add")){
                event.reply("Add initiated").queue();
            }
            // Remove subcommand
            if(event.getSubcommandName().equals("remove")){
                event.reply("Remove initiated").queue();
            }
        }
    }
}
