package fuzs.deleteworldstotrash.client.handler;

import fuzs.deleteworldstotrash.mixin.client.accessor.ConfirmScreenAccessor;
import fuzs.deleteworldstotrash.world.level.storage.WorldTrashUtil;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.ConfirmScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.client.event.ScreenOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TrashScreenHandler {
    private static final Component RECYCLE_BIN_COMPONENT = new TranslatableComponent("deleteworldstotrash.selectWorld.recycleBin");
    private static final Component TRASH_COMPONENT = new TranslatableComponent("deleteworldstotrash.selectWorld.trash");
    private static final Component RECYCLE_BIN_BUTTON_COMPONENT = new TranslatableComponent("deleteworldstotrash.selectWorld.recycleBinButton");
    private static final Component TRASH_BUTTON_COMPONENT = new TranslatableComponent("deleteworldstotrash.selectWorld.trashButton");

    @SubscribeEvent
    public void onScreenOpen(final ScreenOpenEvent evt) {
        final Screen screen = evt.getScreen();
        if (screen instanceof ConfirmScreen && WorldTrashUtil.isTrashSupported()) {
            if (screen.getTitle() instanceof TranslatableComponent title1 && title1.getKey().equals("selectWorld.deleteQuestion") && ((ConfirmScreenAccessor) screen).getTitle2() instanceof TranslatableComponent title2) {
                evt.setScreen(new ConfirmScreen(((ConfirmScreenAccessor) screen).getCallback(), title1, new TranslatableComponent("deleteworldstotrash.selectWorld.deleteWarning", title2.getArgs()[0], hasRecycleBin() ? RECYCLE_BIN_COMPONENT : TRASH_COMPONENT), new TranslatableComponent("deleteworldstotrash.selectWorld.deleteButton", hasRecycleBin() ? RECYCLE_BIN_BUTTON_COMPONENT : TRASH_BUTTON_COMPONENT), CommonComponents.GUI_CANCEL));
            }
        }
    }

    private static boolean hasRecycleBin() {
        return Util.getPlatform() == Util.OS.WINDOWS;
    }
}
