//package ru.fratask.mc.plugin.tp.test;
//
//import com.flowpowered.math.vector.Vector3d;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.slf4j.Logger;
//import org.spongepowered.api.command.args.CommandContext;
//import org.spongepowered.api.entity.living.player.Player;
//import org.spongepowered.api.world.Location;
//import org.spongepowered.api.world.World;
//import ru.fratask.mc.plugin.tp.EasyTeleportPlugin;
//import ru.fratask.mc.plugin.tp.executors.TeleportToPlayerCommandExecutor;
//import ru.fratask.mc.plugin.tp.executors.TeleportToPointCommandExecutor;
//
//import java.lang.reflect.Field;
//
//import static org.junit.Assert.assertEquals;
//
//public class TeleportTest {
//
//    @Test
//    public void teleportToPosTest() throws IllegalAccessException, NoSuchFieldException {
//        EasyTeleportPlugin easyTeleportPlugin = EasyTeleportPlugin.getInstance();
//        Field loggerField = easyTeleportPlugin.getClass().getDeclaredField("logger");
//        loggerField.setAccessible(true);
//        loggerField.set(easyTeleportPlugin, Mockito.mock(Logger.class));
//
//        int counter = 0;
//
//        Player player1 = Mockito.mock(Player.class);
//        Location<World> location = new Location<World>(Mockito.mock(World.class), 1.0, 1.0, 1.0);
//        player1.setLocation(location);
//        TeleportToPointCommandExecutor teleportToPointCommandExecutor = new TeleportToPointCommandExecutor();
//
//        CommandContext commandContext = new CommandContext();
//        commandContext.putArg("X", 100.0);
//        commandContext.putArg("Y", 100.0);
//        commandContext.putArg("Z", 100.0);
//
//        Mockito.when(player1.getName()).thenReturn("Player1");
//        Mockito.when(player1.getWorld()).thenReturn(Mockito.mock(World.class));
//
//        teleportToPointCommandExecutor.execute(player1, commandContext);
//        counter++;
//
//        Mockito.verify(player1, Mockito.times(counter)).setLocation((Location<World>) Mockito.any());
//        assertEquals(player1.getLocation(), new Vector3d(100.0, 100.0, 100.0));
//    }
//
//    @Test
//    public void teleportToPlayerTest() throws NoSuchFieldException, IllegalAccessException {
//        EasyTeleportPlugin easyTeleportPlugin = EasyTeleportPlugin.getInstance();
//        Field loggerField = easyTeleportPlugin.getClass().getDeclaredField("logger");
//        loggerField.setAccessible(true);
//        loggerField.set(easyTeleportPlugin, Mockito.mock(Logger.class));
//
//        int counter = 0;
//
//        Player player1 = Mockito.mock(Player.class);
//        Player player2 = Mockito.mock(Player.class);
//        Location<World> locationForPlayer1 = new Location<World>(Mockito.mock(World.class), 1.0, 1.0, 1.0);
//        player1.setLocation(locationForPlayer1);
//        Location<World> locationForPlayer2 = new Location<World>(Mockito.mock(World.class), 1.0, 1.0, 1.0);
//        player1.setLocation(locationForPlayer2);
//        TeleportToPlayerCommandExecutor teleportToPLayerCommandExecutor = new TeleportToPlayerCommandExecutor();
//        CommandContext commandContext = new CommandContext();
//        commandContext.putArg("player2", player2);
//        Mockito.when(player1.getName()).thenReturn("Player1");
//        Mockito.when(player1.getName()).thenReturn("Player2");
//        Mockito.when(player1.getWorld()).thenReturn(Mockito.mock(World.class));
//        teleportToPLayerCommandExecutor.execute(player1, commandContext);
//        Mockito.verify(player1, Mockito.times(1)).setLocation((Location<World>) Mockito.any());
//    }
//
////    @Test
////    public void teleportFromPlayerToPlaterTest(){
////        EasyTeleportPlugin easyTeleportPlugin = EasyTeleportPlugin.getInstance();
////        Field loggerField = easyTeleportPlugin.getClass().getDeclaredField("logger");
////        loggerField.setAccessible(true);
////        loggerField.set(easyTeleportPlugin, Mockito.mock(Logger.class));
////
////        Player player1 = Mockito.mock(Player.class);
////        TeleportToPointCommandExecutor teleportToPointCommandExecutor = new TeleportToPointCommandExecutor();
////
////        teleportToPointCommandExecutor.execute();
////    }
//}
