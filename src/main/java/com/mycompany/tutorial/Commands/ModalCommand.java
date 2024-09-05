package com.mycompany.tutorial.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class ModalCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        if(event.getName().equals("modal")){
            //  Create new TextInput, subject.
            TextInput subject = TextInput.create("modalSubject", "Subject", TextInputStyle.SHORT)
                .setRequiredRange(5, 100)
                .setPlaceholder("Subject of this modal")
                .build();
            //  Create new TextInput, body.
            TextInput body = TextInput.create("modalBody", "Body", TextInputStyle.PARAGRAPH)
                .setRequiredRange(50, 1500)
                .setPlaceholder("Body of this modal")
                .build();

            //  Create a new Modal, modal
            Modal modal = Modal.create("simpleModal", "Modal")
                //  Add the subject and body to the modal
                .addComponents(ActionRow.of(subject), ActionRow.of(body))
                .build();

            event.replyModal(modal).queue();
        }
    }
}
