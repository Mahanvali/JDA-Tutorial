package com.mycompany.tutorial.Listeners;

import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ModalInteractionListener extends ListenerAdapter {
    @Override
    public void onModalInteraction(ModalInteractionEvent event){
        //  If the modal id that was interacted with equals to "simpleModal"
        if(event.getModalId().equals("simpleModal")){
            //  Get the subject value
            String subject = event.getValue("modalSubject").getAsString();
            //  Get the body value
            String body = event.getValue("modalBody").getAsString();
            //  Print out the subject and body
            System.out.println("SUBJECT: " + subject);
            System.out.println("BODY: " + body);
        }
    }
}
