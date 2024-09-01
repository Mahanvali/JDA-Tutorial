package com.mycompany.tutorial.Listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.Color;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        System.out.println(event.getMessage().getContentDisplay());
        if(event.getMessage().getContentDisplay().equals("!hello")){
            TextChannel messagesentChannel = event.getJDA().getTextChannelById("1273211671883808811");
            Color redColor = new Color(168, 52, 50);
            EmbedBuilder messageEmbedBuilder = new EmbedBuilder();
            messageEmbedBuilder.setColor(redColor);
            messageEmbedBuilder.setTitle("A hello embed");
            messageEmbedBuilder.addField("Hello Field 1", "Hello", false);
            messageEmbedBuilder.setDescription("Hello " + event.getAuthor().getAsMention());
            messagesentChannel.sendMessageEmbeds(messageEmbedBuilder.build())
                .addActionRow(Button.primary("HelloButton", "Click Me")).queue();
        }
    }
}
