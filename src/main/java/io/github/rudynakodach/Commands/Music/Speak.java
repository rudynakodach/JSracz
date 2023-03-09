package io.github.rudynakodach.Commands.Music;

import net.dv8tion.jda.api.entities.channel.concrete.StageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static io.github.rudynakodach.Main.client;

public class Speak extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equalsIgnoreCase("speak")) {
            if (event.getMember().getVoiceState().getChannel() instanceof StageChannel) {
                client.getGuildById(event.getGuild().getId()).getStageChannelById(event.getMember().getVoiceState().getChannel().getId()).requestToSpeak().queue();
                event.getInteraction().reply(":thumbsup:").queue();
            }
        }
    }
}
