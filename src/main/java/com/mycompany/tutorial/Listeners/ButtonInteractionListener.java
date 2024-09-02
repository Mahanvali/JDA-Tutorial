package com.mycompany.tutorial.Listeners;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ButtonInteractionListener extends ListenerAdapter {
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event){
        //  If the button pressed equals the HelloButton ID
        if(event.getComponentId().equals("HelloButton")){
            //  Reply with "YOU CLICKED A BUTTON!!"
            event.reply("YOU CLICKED A BUTTON!!").queue();
        }
    }
}
