package com.intellectualcrafters.plot.api;

import com.intellectualcrafters.configuration.file.YamlConfiguration;
import com.intellectualcrafters.plot.PS;
import com.intellectualcrafters.plot.commands.SubCommand;
import com.intellectualcrafters.plot.config.C;
import com.intellectualcrafters.plot.flag.AbstractFlag;
import com.intellectualcrafters.plot.flag.FlagManager;
import com.intellectualcrafters.plot.object.Plot;
import com.intellectualcrafters.plot.object.PlotArea;
import com.intellectualcrafters.plot.object.PlotId;
import com.intellectualcrafters.plot.object.PlotManager;
import com.intellectualcrafters.plot.object.PlotPlayer;
import com.intellectualcrafters.plot.util.ChunkManager;
import com.intellectualcrafters.plot.util.MainUtil;
import com.intellectualcrafters.plot.util.SchematicHandler;
import com.intellectualcrafters.plot.util.SetQueue;
import com.intellectualcrafters.plot.util.UUIDHandler;
import com.intellectualcrafters.plot.uuid.UUIDWrapper;
import com.plotsquared.bukkit.util.BukkitUtil;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * PlotSquared API.
 * <br>
 * <br>
 * Useful classes:<br>
 * @see BukkitUtil
 * @see PlotPlayer
 * @see Plot
 * @see com.intellectualcrafters.plot.object.Location
 * @see PlotArea
 * @see PS
 * @version 3.3.3
>>>>>>> origin/master
 */
public class PlotAPI {

    /**
     * Permission that allows for admin access, this permission node will allow
     * the player to use any part of the plugin, without limitations.
     * @deprecated Use C.PERMISSION_ADMIN instead
     */
    @Deprecated
    public static final String ADMIN_PERMISSION = C.PERMISSION_ADMIN.s();

    /**
     * Deprecated, does nothing.
     * @param plugin not needed
     * @deprecated Not needed
     */
    @Deprecated
    public PlotAPI(JavaPlugin plugin) {
    }

    /**
     * Default Constructor that does nothing.
     *
     * @deprecated Use this class if you just want to do a few simple things
     *      <ul>
     *          <li>It will remain stable for future versions
     *              of the plugin</li>
     *          <li>The PlotPlayer and Plot class should be considered
     *              relatively safe</li>
     *          <li>For more advanced/intensive tasks you should consider
     *              using other classes</li>
     *      </ul>
     *
     */
    @Deprecated
    public PlotAPI() {
    }

    /**
     * Get all plots.
     *
     * @return all plots
     *
     * @see PS#getPlots()
     */
    public Set<Plot> getAllPlots() {
        return PS.get().getPlots();
    }

    /**
     * Return all plots for a player.
     *
     * @param player Player, whose plots to search for
     *
     * @return all plots that a player owns
     */
    public Set<Plot> getPlayerPlots(Player player) {
        return PS.get().getPlots(BukkitUtil.getPlayer(player));
    }

    /**
     * Add a plot world.
     *
     * @param plotArea Plot World Object
     * @see PS#addPlotArea(PlotArea)
     */
    public void addPlotArea(PlotArea plotArea) {
        PS.get().addPlotArea(plotArea);
    }

    /**
     * Returns the PlotSquared configurations file.
     * @return main configuration
     *
     * @see PS#config
     */
    public YamlConfiguration getConfig() {
        return PS.get().config;
    }

    /**
     * Get the PlotSquared storage file.
     * @return storage configuration
     *
     * @see PS#storage
     */
    public YamlConfiguration getStorage() {
        return PS.get().storage;
    }

    /**
     * Get the main class for this plugin. Only use this if you really need it.
     *
     * @return PlotSquared PlotSquared Main Class
     *
     * @see PS
     */
    public PS getMain() {
        return PS.get();
    }

    /**
     * ChunkManager class contains several useful methods.
     * <ul>
     *     <li>Chunk deletion</li>
     *     <li>Moving or copying regions</li>
     *     <li>Plot swapping</li>
     *     <li>Entity Tracking</li>
     *     <li>Region Regeneration</li>
     * </ul>
     *
     * @return ChunkManager
     *
     * @see com.intellectualcrafters.plot.util.ChunkManager
     */
    public ChunkManager getChunkManager() {
        return ChunkManager.manager;
    }

    /**
     * Get the block/biome set queue
     * @return SetQueue.IMP
     */
    public SetQueue getSetQueue() {
        return SetQueue.IMP;
    }

    /**
     * UUIDWrapper class has basic methods for getting UUIDS. It's recommended
     * to use the UUIDHandler class instead.
     *
     * @return UUIDWrapper
     *
     * @see com.intellectualcrafters.plot.uuid.UUIDWrapper
     */
    public UUIDWrapper getUUIDWrapper() {
        return UUIDHandler.getUUIDWrapper();
    }

    /**
     * Do not use this. Instead use FlagManager.[method] in your code.
     *  - Flag related stuff
     *
     * @return FlagManager
     *
     * @deprecated Use {@link FlagManager} directly
     */
    @Deprecated
    public FlagManager getFlagManager() {
        return new FlagManager();
    }

    /**
     * Do not use this. Instead use MainUtil.[method] in your code.
     *
     * @return MainUtil
     * @deprecated Use {@link MainUtil} directly
     */
    @Deprecated
    public MainUtil getMainUtil() {
        return new MainUtil();
    }

    /**
     * Do not use this. Instead use C.PERMISSION_[method] in your code.
     *
     * @return Array of strings
     *
     * @see com.intellectualcrafters.plot.util.Permissions
     * @deprecated Use {@link C} to list all the permissions
     */
    @Deprecated
    public String[] getPermissions() {
        ArrayList<String> perms = new ArrayList<>();
        for (C c : C.values()) {
            if ("static.permissions".equals(c.getCategory())) {
                perms.add(c.s());
            }
        }
        return perms.toArray(new String[perms.size()]);
    }

    /**
     * SchematicHandler class contains methods related to pasting, reading
     * and writing schematics.
     *
     * @return SchematicHandler
     *
     * @see com.intellectualcrafters.plot.util.SchematicHandler
     */
    public SchematicHandler getSchematicHandler() {
        return SchematicHandler.manager;
    }

    /**
     * Use C.[caption] instead
     *
     * @return C
     * @deprecated Use {@link C}
     */
    @Deprecated
    public C[] getCaptions() {
        return C.values();
    }

    /**
     * Get the plot manager for a world. Most of these methods can be accessed
     * through the MainUtil.
     *
     * @param world Which manager to get
     *
     * @return PlotManager
     *
     * @see com.intellectualcrafters.plot.object.PlotManager
     * @see PS#getPlotManager(Plot)
     */
    @Deprecated
    public PlotManager getPlotManager(World world) {
        if (world == null) {
            return null;
        }
        return getPlotManager(world.getName());
    }

    /**
     * Get a list of PlotAreas in the world.
     * @param world The world to check for plot areas
     * @return A set of PlotAreas
     */
    public Set<PlotArea> getPlotAreas(World world) {
        if (world == null) {
            return new HashSet<>();
        }
        return PS.get().getPlotAreas(world.getName());
    }

    /**
     * Get the plot manager for a world. Contains useful low level methods for
     * plot merging, clearing, and tessellation.
     *
     * @param world The world
     *
     * @return PlotManager
     *
     * @see PS#getPlotManager(Plot)
     * @see com.intellectualcrafters.plot.object.PlotManager
     */
    @Deprecated
    public PlotManager getPlotManager(String world) {
        Set<PlotArea> areas = PS.get().getPlotAreas(world);
        switch (areas.size()) {
            case 0:
                return null;
            case 1:
                return areas.iterator().next().manager;
            default:
                PS.debug("PlotAPI#getPlotManager(org.bukkit.World) is deprecated and doesn't support multi plot area worlds.");
                return null;
        }
    }

    /**
     * Get the settings for a world (settings bundled in PlotArea class). You
     * will need to downcast for the specific settings a Generator has. e.g.
     * DefaultPlotWorld class implements PlotArea
     *
     * @param world The World
     *
     * @return The {@link PlotArea} for the world or null if not in plotworld
     *
     * @see #getPlotAreas(World)
     * @see com.intellectualcrafters.plot.object.PlotArea
     */
    @Deprecated
    public PlotArea getWorldSettings(World world) {
        if (world == null) {
            return null;
        }
        return getWorldSettings(world.getName());
    }

    /**
     * Get the settings for a world.
     *
     * @param world The world
     *
     * @return The {@link PlotArea} for the world or null if not in plotworld
     *
     * @see PS#getPlotArea(String, String)
     * @see com.intellectualcrafters.plot.object.PlotArea
     */
    @Deprecated
    public PlotArea getWorldSettings(String world) {
        if (world == null) {
            return null;
        }
        Set<PlotArea> areas = PS.get().getPlotAreas(world);
        switch (areas.size()) {
            case 0:
                return null;
            case 1:
                return areas.iterator().next();
            default:
                PS.debug("PlotAPI#getWorldSettings(org.bukkit.World) is deprecated and doesn't support multi plot area worlds.");
                return null;
        }
    }

    /**
     * Send a message to a player.
     *
     * @param player Player that will receive the message
     * @param caption Caption
     *
     * @see MainUtil#sendMessage(PlotPlayer, C, String...)
     */
    public void sendMessage(Player player, C caption) {
        MainUtil.sendMessage(BukkitUtil.getPlayer(player), caption);
    }

    /**
     * Send a message to a player. Supports color codes.
     *
     * @param player Player that will receive the message
     * @param string The message
     *
     * @see MainUtil#sendMessage(PlotPlayer, String)
     */
    public void sendMessage(Player player, String string) {
        MainUtil.sendMessage(BukkitUtil.getPlayer(player), string);
    }

    /**
     * Send a message to the console. Supports color codes.
     *
     * @param message Message that should be sent to the console
     *
     * @see MainUtil#sendConsoleMessage(C, String...)
     */
    public void sendConsoleMessage(String message) {
        PS.log(message);
    }

    /**
     * Send a message to the console.
     *
     * @param caption The caption
     *
     * @see #sendConsoleMessage(String)
     * @see com.intellectualcrafters.plot.config.C
     */
    public void sendConsoleMessage(C caption) {
        sendConsoleMessage(caption.s());
    }

    /**
     * Register a flag for use in plots.
     *
     * @param flag Flag that should be registered
     *
     * @see com.intellectualcrafters.plot.flag.FlagManager#addFlag(com.intellectualcrafters.plot.flag.AbstractFlag)
     * @see com.intellectualcrafters.plot.flag.AbstractFlag
     */
    public void addFlag(AbstractFlag flag) {
        FlagManager.addFlag(flag);
    }

    /**
     * get all the currently registered flags.
     *
     * @return array of Flag[]
     *
     * @see com.intellectualcrafters.plot.flag.FlagManager#getFlags()
     * @see com.intellectualcrafters.plot.flag.AbstractFlag
     */
    public AbstractFlag[] getFlags() {
        return FlagManager.getFlags().toArray(new AbstractFlag[FlagManager.getFlags().size()]);
    }

    /**
     * Get a plot based on the ID.
     *
     * @param world World in which the plot is located
     * @param x The PlotID x coordinate
     * @param z The PlotID y coordinate
     *
     * @return plot, null if ID is wrong
     *
     * @see PlotArea#getPlot(PlotId)
     */
    @Deprecated
    public Plot getPlot(World world, int x, int z) {
        if (world == null) {
            return null;
        }
        PlotArea area = getWorldSettings(world);
        if (area == null) {
            return null;
        }
        return area.getPlot(new PlotId(x, z));
    }

    /**
     * Get a plot based on the location.
     *
     * @param location The location to retrieve the plot from
     *
     * @return plot if found, otherwise it creates a temporary plot
     *
     * @see Plot
     */
    public Plot getPlot(Location location) {
        if (location == null) {
            return null;
        }
        return BukkitUtil.getLocation(location).getPlot();
    }

    /**
     * Get a plot based on the player location.
     *
     * @param player Get the current plot for the player location
     *
     * @return plot if found, otherwise it creates a temporary plot
     *
     * @see #getPlot(org.bukkit.Location)
     * @see Plot
     */
    public Plot getPlot(Player player) {
        return this.getPlot(player.getLocation());
    }

    /**
     * Check whether or not a player has a plot.
     *
     * @param player Player that you want to check for
     * @param world The world to check
     * @return true if player has a plot, false if not.
     *
     * @see #getPlots(World, Player, boolean)
     */
    @Deprecated
    public boolean hasPlot(World world, Player player) {
        return getPlots(world, player, true).length > 0;
    }

    /**
     * Get all plots for the player.
     *
     * @param world The world to retrieve plots from
     * @param player The player to search for
     * @param justOwner should we just search for owner? Or with rights?
     * @return An array of plots for the player
     */
    @Deprecated
    public Plot[] getPlots(World world, Player player, boolean justOwner) {
        ArrayList<Plot> pPlots = new ArrayList<>();
        UUID uuid = BukkitUtil.getPlayer(player).getUUID();
        for (Plot plot : PS.get().getPlots(world.getName())) {
            if (justOwner) {
                if (plot.hasOwner() && plot.isOwner(uuid)) {
                    pPlots.add(plot);
                }
            } else if (plot.isAdded(uuid)) {
                pPlots.add(plot);
            }
        }
        return pPlots.toArray(new Plot[pPlots.size()]);
    }

    /**
     * Get all plots for the world.
     *
     * @param world to get plots of
     *
     * @return Plot[] - array of plot objects in world
     *
     * @see PS#getPlots(String)
     * @see Plot
     */
    @Deprecated
    public Plot[] getPlots(World world) {
        if (world == null) {
            return new Plot[0];
        }
        Collection<Plot> plots = PS.get().getPlots(world.getName());
        return plots.toArray(new Plot[plots.size()]);
    }

    /**
     * Get all plot worlds.
     *
     * @return World[] - array of plot worlds
     *
     */
    @Deprecated
    public String[] getPlotWorlds() {
        Set<String> plotWorldStrings = PS.get().getPlotWorldStrings();
        return plotWorldStrings.toArray(new String[plotWorldStrings.size()]);
    }

    /**
     * Get if plotworld.
     *
     * @param world The world to check
     *
     * @return boolean (if plot world or not)
     *
     * @see PS#hasPlotArea(String)
     */
    @Deprecated
    public boolean isPlotWorld(World world) {
        return PS.get().hasPlotArea(world.getName());
    }

    /**
     * Get plot locations.
     *
     * @param plot Plot to get the locations for
     *
     * @return [0] = bottomLc, [1] = topLoc, [2] = home
     *
     * @deprecated As merged plots may not have a rectangular shape
     *
     * @see Plot
     */
    @Deprecated
    public Location[] getLocations(Plot plot) {
        Location bukkitBottom = BukkitUtil.getLocation(plot.getCorners()[0]);
        Location bukkitTop = BukkitUtil.getLocation(plot.getCorners()[1]);
        Location bukkitHome = BukkitUtil.getLocation(plot.getHome());
        return new Location[]{bukkitBottom, bukkitTop, bukkitHome};
    }

    /**
     * Get home location.
     *
     * @param plot Plot that you want to get the location for
     *
     * @return plot bottom location
     *
     * @see Plot
     */
    public Location getHomeLocation(Plot plot) {
        return BukkitUtil.getLocation(plot.getHome());
    }

    /**
     * Get Bottom Location (min, min, min).
     *
     * @param plot Plot that you want to get the location for
     *
     * @return plot bottom location
     *
     * @deprecated As merged plots may not have a rectangular shape
     *
     * @see Plot
     */
    @Deprecated
    public Location getBottomLocation(Plot plot) {
        return BukkitUtil.getLocation(plot.getBottom());
    }

    /**
     * Get Top Location (max, max, max).
     *
     * @param plot Plot that you want to get the location for
     *
     * @return plot top location
     *
     * @deprecated As merged plots may not have a rectangular shape
     *
     * @see Plot
     */
    @Deprecated
    public Location getTopLocation(Plot plot) {
        return BukkitUtil.getLocation(plot.getTop());
    }

    /**
     * Check whether or not a player is in a plot.
     *
     * @param player who we're checking for
     *
     * @return true if the player is in a plot, false if not-
     *
     */
    public boolean isInPlot(Player player) {
        return getPlot(player) != null;
    }

    /**
     * Register a subcommand.
     * @deprecated Command registration is done on object creation
     * @param c SubCommand, that we want to register
     * @see com.intellectualcrafters.plot.commands.SubCommand
     */
    @Deprecated
    public void registerCommand(SubCommand c) {
        PS.debug("SubCommands are now registered on creation");
    }

    /**
     * Get the PlotSquared class.
     *
     * @return PlotSquared Class
     *
     * @see PS
     */
    public PS getPlotSquared() {
        return PS.get();
    }

    /**
     * Get the player plot count.
     *
     * @param world  Specify the world we want to select the plots from
     * @param player Player, for whom we're getting the plot count
     *
     * @return the number of plots the player has
     *
     */
    public int getPlayerPlotCount(World world, Player player) {
        if (world == null) {
            return 0;
        }
        return BukkitUtil.getPlayer(player).getPlotCount(world.getName());
    }

    /**
     * Get a collection containing the players plots.
     *
     * @param world  Specify the world we want to select the plots from
     * @param player Player, for whom we're getting the plots
     *
     * @return a set containing the players plots
     *
     * @see PS#getPlots(String, PlotPlayer)
     *
     * @see Plot
     */
    public Set<Plot> getPlayerPlots(World world, Player player) {
        if (world == null) {
            return new HashSet<>();
        }
        return BukkitUtil.getPlayer(player).getPlots(world.getName());
    }

    /**
     * Get the numbers of plots, which the player is able to build in.
     *
     * @param player Player, for whom we're getting the plots
     *
     * @return the number of allowed plots
     *
     */
    public int getAllowedPlots(Player player) {
        PlotPlayer pp = BukkitUtil.getPlayer(player);
        return pp.getAllowedPlots();
    }

    /**
     * Get the PlotPlayer for a player. The PlotPlayer is usually cached and
     * will provide useful functions relating to players.
     *
     * @see PlotPlayer#wrap(Object)
     *
     * @param player The player to wrap
     * @return A PlotPlayer
     */
    public PlotPlayer wrapPlayer(Player player) {
        return PlotPlayer.wrap(player);
    }

    /**
     * Get the PlotPlayer for a UUID.
     *
     * <p><i>Please note that PlotSquared can be configured to provide
     * different UUIDs than bukkit</i></p>
     *
     * @see PlotPlayer#wrap(Object)
     *
     * @param uuid The uuid of the player to wrap
     * @return A PlotPlayer
     */
    public PlotPlayer wrapPlayer(UUID uuid) {
        return PlotPlayer.wrap(uuid);
    }

    /**
     * Get the PlotPlayer for a username.
     *
     * @see PlotPlayer#wrap(Object)
     *
     * @param player The player to wrap
     * @return The PlotPlayer
     */
    public PlotPlayer wrapPlayer(String player) {
        return PlotPlayer.wrap(player);
    }

    /**
     * Get the PlotPlayer for an offline player.
     * <p>Note that this will work if the player is offline, however not all
     * functionality will work</p>
     *
     * @see PlotPlayer#wrap(Object)
     *
     * @param player The player to wrap
     * @return The PlotPlayer
     */
    public PlotPlayer wrapPlayer(OfflinePlayer player) {
        return PlotPlayer.wrap(player);
    }
}
