package ru.fratask.mc.plugin.tp.executors;

import com.flowpowered.math.vector.Vector3d;
import org.slf4j.Logger;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import ru.fratask.mc.plugin.tp.EasyTeleportPlugin;

public class TeleportToPointCommandExecutor implements CommandExecutor {

    Logger logger = EasyTeleportPlugin.getLogger();

    public CommandResult execute(CommandSource src, CommandContext args) {

        double X = Double.parseDouble(String.valueOf(args.getOne("X").get()));
        double Y = Double.parseDouble(String.valueOf(args.getOne("Y").get()));
        double Z = Double.parseDouble(String.valueOf(args.getOne("Z").get()));
        Vector3d teleportPosition = new Vector3d(X, Y, Z);
        ((Player) src).setLocation(teleportPosition, ((Player) src).getWorld().getUniqueId());

        src.sendMessage(Text.of(TextColors.YELLOW, "You teleported to %f, %f, %f", X, Y, Z));
        logger.info("Player " + src.getName() + " teleported to %f, %f, %f", X, Y, Z);
        return CommandResult.success();
    }
}
