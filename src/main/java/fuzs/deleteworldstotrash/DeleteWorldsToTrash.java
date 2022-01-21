package fuzs.deleteworldstotrash;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DeleteWorldsToTrash.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeleteWorldsToTrash {
    public static final String MOD_ID = "deleteworldstotrash";
    public static final String MOD_NAME = "Delete Worlds To Trash";
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
}
