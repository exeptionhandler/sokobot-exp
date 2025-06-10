package me.polymarsdev.sokobot.commands;

import me.polymarsdev.sokobot.Bot;
import me.polymarsdev.sokobot.entity.Command;
import me.polymarsdev.sokobot.event.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;

public class InfoCommand extends Command {

    public InfoCommand() {
        super("info");
    }

    @Override
   public void execute(CommandEvent event) {
        Bot.debug("Received info command (or bot mention)");
        Guild guild = event.getGuild();
        EmbedBuilder info = new EmbedBuilder();
        final String prefix = Bot.getPrefix(guild);
        info.setTitle("Sokobot");
        info.setThumbnail(guild.getSelfMember().getUser().getAvatarUrl());
        info.setDescription("Sokobot es un bot que te permite jugar a Sokoban, el cl\u00e1sico juego de rompecabezas de empujar cajas.");
        info.setColor(0xdd2e53);
        info.addField("C\u00f3mo jugar", "Eres un/a **Sokoban** :sunglasses: .\nTu trabajo es empujar **cajas** :brown_square: "
                + "encima de su **destino** :negative_squared_cross_mark:.", false);
        info.addField("Características", ":white_small_square:**Niveles Infinifos**\nLos mapas en Sokobot son aleatoriamente "
                + "generados, aumentando en dificultad a medida que avanza.\n:white_small_square:**Variedad " + "de " + "controles"
                + "**\nSokobot tiene m\u00faltiples opciones de control para mejorar la experiencia del jugador, incluyendo"
                + "reacciones y comandos wasd!\n:white_small_square:**Juegos simultaneos**\nGracias al poder de "
                + "Java Hashmaps:tm:, varios usuarios pueden usar el bot al mismo tiempo sin interferir entre"
                + " s\u00ed.\n:white_small_square:**Prefijos personalizados**\nPara evitar que Sokobot entre en conflicto con otros"
                + "bots, los administradores pueden elegir cualquier prefijo de un solo car\u00e1cter para preceder los comandos de Sokobot.", false);
        info.addField(
                "Commands",
                ("``" + prefix + "play`` se puede utilizar para iniciar un juego si no" + "actualmente en " + "uno.\n``"
                        + prefix + "stop`` se puede utilizar para detener su juego activo en cualquier " + "momento.\n``" + prefix
                        + "info`` proporciona algunos detalles \u00fatiles sobre el bot y " + "las reglas del" + "juego.\n``" + Bot
                        .getPrefix(guild) + "prefix [car\u00e1cter]`` puede ser usado para" + "cambiar el prefijo que el"
                        + "bot responde a."), false);
        info.addField(
                "Agregar a su servidor",
                "https://discord.ly/sokobot-espanol\nSokobot Espa\u00f1ol se encuentra actualmente en " + Bot.getShardManager().getGuilds()
                                                                                       .size() + " servidores.", false);
        info.addField(
                     "Bot Original \n",
                     "https://top.gg/bot/713635251703906336" , false );
        /*
        // Official Support Server
        info.addField("Support / Feedback",
        "Official Support Server: https://invite.affluentproductions.org/apserver", false);
         */
        info.addField("C\u00f3digo fuente", "https://github.com/PolyMarsDev/Sokobot", false);
        info.addField("Traductor", "https://discordbotlist.com/users/637075746233384960", false);
        info.setFooter("Creado por PolyMars", "https://avatars0.githubusercontent" + ".com/u/51007356?s=460&u"
                + "=4eb8fd498421a2eee9781edfbadf654386cf06c7&v=4");
        event.reply(info.build());
    }
}
