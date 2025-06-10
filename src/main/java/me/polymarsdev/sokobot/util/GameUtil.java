package me.polymarsdev.sokobot.util;

import me.polymarsdev.sokobot.Bot;
import me.polymarsdev.sokobot.Game;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class GameUtil {

    private static final HashMap<Long, Game> games = new HashMap<>();

    public static void setGame(long userId, Game game) {
        games.put(userId, game);
    }

    public static boolean hasGame(long userId) {
        return games.containsKey(userId);
    }

    public static Game getGame(long userId) {
        return games.get(userId);
    }

    public static void removeGame(long userId) {
        games.remove(userId);
    }

    public static void sendGameEmbed(MessageChannel channel, String level, String game, User user) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Sokobot | Nivel " + level);
        embed.setDescription(game);
        embed.addField("Ingrese direcci\u00f3n (``arriba``, ``abajo``, ``izquierda``, ``derecha``/``wasd``), ``r`` para reiniciar o ``mr`` para "
                               + "recrear el mapa", "", false);
        embed.addField("Jugador", user.getAsMention(), false);
        channel.sendMessage(embed.build()).queue(message -> {
            message.addReaction("U+2B05").queue();
            message.addReaction("U+27A1").queue();
            message.addReaction("U+2B06").queue();
            message.addReaction("U+2B07").queue();
            message.addReaction("U+1F504").queue();
            Game theGame = GameUtil.getGame(user.getIdLong());
            theGame.setGameMessage(message);
        });
    }

    public static void updateGameEmbed(Message message, String level, String game, User user) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Sokobot | Nivel " + level);
        embed.setDescription(game);
        embed.addField("Ingrese direcci\u00f3n (``arriba``, ``abajo``, ``izquierda``, ``derecha``/``wasd``), ``r`` para reiniciar ``mr`` para "
                               + "recrear el mapa", "", false);
        embed.addField("Jugador", user.getAsMention(), false);
        message.editMessage(embed.build()).queue();
    }

    public static void sendWinEmbed(Guild guild, Message message, String level) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Sokobot | Ganaste! :sunglasses:");
        embed.setDescription(
                "Escribe ``" + Bot.getPrefix(guild) + "continue`` para continuar el nivel " + level + " o ``" + Bot
                        .getPrefix(guild) + "stop`` para salir ");
        embed.setFooter("Tambi\u00e9n puedes presionar cualquier reacci\u00f3 n para continuar.");
        message.editMessage(embed.build()).queue();
    }

    public static void runGameTimer() {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long now = System.currentTimeMillis();
                for (long playerId : games.keySet()) {
                    Game game = games.get(playerId);
                    long timeDifference = now - game.lastAction;
                    if (timeDifference > 10 * 60 * 1000) {
                        System.out.println("[INFO] Se ha interrumpido el juego activo de " + playerId);
                        game.stop();
                        GameUtil.removeGame(playerId);
                    }
                }
            }
        }, 10 * 60 * 1000, 60 * 1000);
    }
}