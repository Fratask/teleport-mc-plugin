package ru.fratask.mc.plugin.tp;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import ru.fratask.mc.plugin.tp.executors.TeleportFromPlayerToPlayerCommandExecutor;
import ru.fratask.mc.plugin.tp.executors.TeleportToPlayerCommandExecutor;
import ru.fratask.mc.plugin.tp.executors.TeleportToPointCommandExecutor;

@Plugin(id = "easy-teleport-plugin")
public class EasyTeleportPlugin {

    private static EasyTeleportPlugin instance;

    @Inject
    private static Logger logger;

    @Listener
    public void onServerStart(GameInitializationEvent event){
        instance = this;
        logger.info("EasyTeleportPlugin is loaded");

        Sponge.getCommandManager().register(instance, getTeleportToPointCommand(), "teleport", "tp");
        Sponge.getCommandManager().register(instance, getTeleportToPlayerCommand(), "teleport", "tp");
    }

    private CommandSpec getTeleportToPointCommand(){
        return CommandSpec.builder()
                .description(Text.of("<X> <Y <Z> | /tp <X> <Y> <Z> | Teleports for XYZ coordinates/"))
                .arguments(
                        GenericArguments.onlyOne(GenericArguments.doubleNum(Text.of("X"))),
                        GenericArguments.onlyOne(GenericArguments.doubleNum(Text.of("Y"))),
                        GenericArguments.onlyOne(GenericArguments.doubleNum(Text.of("Z"))))
                .executor(new TeleportToPointCommandExecutor())
                .build();
    }

    private CommandSpec getTeleportToPlayerCommand(){
        return CommandSpec.builder()
                .description(Text.of("<player> | /tp <player> | Teleports to player"))
                .arguments(
                        GenericArguments.onlyOne(GenericArguments.player(Text.of("player"))))
                .executor(new TeleportToPlayerCommandExecutor())
                .build();
    }

    private CommandSpec getTeleportFromPlayerToPlayerCommand(){
        return CommandSpec.builder()
                .description(Text.of("<player1> <player2>| /tp <player1> <toPlayer2> | Teleports first player to second player"))
                .arguments(
                        GenericArguments.onlyOne(GenericArguments.player(Text.of("player1"))),
                        GenericArguments.onlyOne(GenericArguments.player(Text.of("player1"))))
                .executor(new TeleportFromPlayerToPlayerCommandExecutor())
                .build();
    }

    public static EasyTeleportPlugin getInstance() {
        if (instance == null){
            instance = new EasyTeleportPlugin();
        }
        return instance;
    }

    public static Logger getLogger() {
        return logger;
    }
}
