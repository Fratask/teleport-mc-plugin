package ru.fratask.mc.plugin.tp.executors;

import org.slf4j.Logger;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import ru.fratask.mc.plugin.tp.EasyTeleportPlugin;

public class TeleportToPlayerCommandExecutor implements CommandExecutor {

    Logger logger = EasyTeleportPlugin.getInstance().getLogger();

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) {

        Player player1 = (Player) src;
        Player player2 = (Player) args.getOne("player2").get();
        if (player1.getName().equals(player2.getName())){
            player1.sendMessage(Text.of(TextColors.RED, "You must choose another player!"));
        } else if (!player2.isOnline()){
            player1.sendMessage(Text.of(TextColors.RED, "You must choose online player!"));
        } else {
            player1.setLocation(player2.getLocation());

            player1.sendMessage(Text.of(TextColors.YELLOW, "You teleported to " + player2.getName()));
            player2.sendMessage(Text.of(TextColors.YELLOW, "Player " + player1.getName() + " teleported to you"));
            logger.info("Player " + player1.getName() + " teleported to player " + player2);
        }
        return CommandResult.success();
    }
}
