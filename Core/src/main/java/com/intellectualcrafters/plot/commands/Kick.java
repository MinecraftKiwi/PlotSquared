package com.intellectualcrafters.plot.commands;

import com.intellectualcrafters.plot.config.C;
import com.intellectualcrafters.plot.object.Location;
import com.intellectualcrafters.plot.object.Plot;
import com.intellectualcrafters.plot.object.PlotPlayer;
import com.intellectualcrafters.plot.util.MainUtil;
import com.intellectualcrafters.plot.util.Permissions;
import com.intellectualcrafters.plot.util.UUIDHandler;
import com.intellectualcrafters.plot.util.WorldUtil;
import com.plotsquared.general.commands.Argument;
import com.plotsquared.general.commands.CommandDeclaration;

@CommandDeclaration(command = "kick",
        aliases = {"k"},
        description = "Kick a player from your plot",
        permission = "plots.kick",
        usage = "<player>",
        category = CommandCategory.TELEPORT,
        requiredType = RequiredType.PLAYER)
public class Kick extends SubCommand {

    public Kick() {
        super(Argument.PlayerName);
    }

    @Override
    public boolean onCommand(PlotPlayer plr, String[] args) {
        Location loc = plr.getLocation();
        Plot plot = loc.getPlot();
        if (plot == null) {
            return !sendMessage(plr, C.NOT_IN_PLOT);
        }
        if ((!plot.hasOwner() || !plot.isOwner(plr.getUUID())) && !Permissions.hasPermission(plr, "plots.admin.command.kick")) {
            MainUtil.sendMessage(plr, C.NO_PLOT_PERMS);
            return false;
        }
        PlotPlayer player = UUIDHandler.getPlayer(args[0]);
        if (player == null) {
            MainUtil.sendMessage(plr, C.INVALID_PLAYER, args[0]);
            return false;
        }
        Location otherLoc = player.getLocation();
        if (!plr.getLocation().getWorld().equals(otherLoc.getWorld()) || !plot.equals(otherLoc.getPlot())) {
            MainUtil.sendMessage(plr, C.INVALID_PLAYER, args[0]);
            return false;
        }
        if (player.hasPermission("plots.admin.entry.denied")) {
            C.CANNOT_KICK_PLAYER.send(plr, player.getName());
            return false;
        }
        Location spawn = WorldUtil.IMP.getSpawn(loc.getWorld());
        C.YOU_GOT_KICKED.send(player);
        if (plot.equals(spawn.getPlot())) {
            Location newSpawn = WorldUtil.IMP.getSpawn(player);
            if (plot.equals(newSpawn.getPlot())) {
                // Kick from server if you can't be teleported to spawn
                player.kick(C.YOU_GOT_KICKED.s());
            } else {
                player.teleport(newSpawn);
            }
        } else {
            player.teleport(spawn);
        }
        return true;
    }
}
