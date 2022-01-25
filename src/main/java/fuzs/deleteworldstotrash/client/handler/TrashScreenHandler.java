package fuzs.deleteworldstotrash.client.handler;

import fuzs.deleteworldstotrash.mixin.client.accessor.ConfirmScreenAccessor;
import fuzs.deleteworldstotrash.world.level.storage.TrashComponentUtil;
import fuzs.deleteworldstotrash.world.level.storage.WorldTrashUtil;
import net.minecraft.client.gui.screens.ConfirmScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.client.event.ScreenOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TrashScreenHandler {
    @SubscribeEvent
    public void onScreenOpen(final ScreenOpenEvent evt) {
        final Screen screen = evt.getScreen();
        if (screen instanceof ConfirmScreen && WorldTrashUtil.isTrashSupported()) {
            if (screen.getTitle() instanceof TranslatableComponent title1 && title1.getKey().equals("selectWorld.deleteQuestion") && ((ConfirmScreenAccessor) screen).getTitle2() instanceof TranslatableComponent title2) {
                evt.setScreen(new ConfirmScreen(((ConfirmScreenAccessor) screen).getCallback(), title1, new TranslatableComponent("deleteworldstotrash.selectWorld.deleteWarning", title2.getArgs()[0], TrashComponentUtil.getTrashComponent()), new TranslatableComponent("deleteworldstotrash.selectWorld.deleteButton", TrashComponentUtil.getTrashButtonComponent()), CommonComponents.GUI_CANCEL));
            }
        }
    }
}
