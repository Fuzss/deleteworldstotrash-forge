package fuzs.deleteworldstotrash;

import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(DeleteWorldsToTrash.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DeleteWorldsToTrash {
    public static final String MOD_ID = "deleteworldstotrash";
    public static final String MOD_NAME = "Delete Worlds To Trash";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
}
