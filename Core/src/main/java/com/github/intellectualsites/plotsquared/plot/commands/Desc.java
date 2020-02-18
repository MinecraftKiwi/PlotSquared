package com.github.intellectualsites.plotsquared.plot.commands;

import com.github.intellectualsites.plotsquared.commands.CommandDeclaration;
import com.github.intellectualsites.plotsquared.plot.config.Captions;
import com.github.intellectualsites.plotsquared.plot.flags.GlobalFlagContainer;
import com.github.intellectualsites.plotsquared.plot.flags.implementations.DescriptionFlag;
import com.github.intellectualsites.plotsquared.plot.object.Plot;
import com.github.intellectualsites.plotsquared.plot.object.PlotPlayer;
import com.github.intellectualsites.plotsquared.plot.util.MainUtil;

@CommandDeclaration(command = "setdescription", permission = "plots.set.desc", description = "Set the plot description", usage = "/plot desc <description>", aliases = {
    "desc", "setdesc", "setd",
    "description"}, category = CommandCategory.SETTINGS, requiredType = RequiredType.PLAYER)
public class Desc extends SetCommand {

    @Override public boolean set(PlotPlayer player, Plot plot, String desc) {
        if (desc.isEmpty()) {
            plot.removeFlag(DescriptionFlag.class);
            MainUtil.sendMessage(player, Captions.DESC_UNSET);
            return true;
        }
        boolean result = plot.setFlag(GlobalFlagContainer.getInstance().getFlag(DescriptionFlag.class).createFlagInstance(desc));
        if (!result) {
            MainUtil.sendMessage(player, Captions.FLAG_NOT_ADDED);
            return false;
        }
        MainUtil.sendMessage(player, Captions.DESC_SET);
        return true;
    }
}
