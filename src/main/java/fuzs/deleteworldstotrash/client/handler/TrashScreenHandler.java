package fuzs.deleteworldstotrash.client.handler;

import fuzs.deleteworldstotrash.mixin.client.accessor.ConfirmScreenAccessor;
import fuzs.deleteworldstotrash.world.level.storage.WorldTrashUtil;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.screen.ConfirmScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TrashScreenHandler {
    private static final ITextComponent RECYCLE_BIN_COMPONENT = new TranslationTextComponent("deleteworldstotrash.selectWorld.recycleBin");
    private static final ITextComponent TRASH_COMPONENT = new TranslationTextComponent("deleteworldstotrash.selectWorld.trash");
    private static final ITextComponent RECYCLE_BIN_BUTTON_COMPONENT = new TranslationTextComponent("deleteworldstotrash.selectWorld.recycleBinButton");
    private static final ITextComponent TRASH_BUTTON_COMPONENT = new TranslationTextComponent("deleteworldstotrash.selectWorld.trashButton");

    @SubscribeEvent
    public void onScreenOpen(final GuiOpenEvent evt) {
        final Screen screen = evt.getGui();
        if (screen instanceof ConfirmScreen && WorldTrashUtil.isTrashSupported()) {
            if (screen.getTitle() instanceof TranslationTextComponent && ((TranslationTextComponent) screen.getTitle()).getKey().equals("selectWorld.deleteQuestion") && ((ConfirmScreenAccessor) screen).getTitle2() instanceof TranslationTextComponent) {
                evt.setGui(new ConfirmScreen(((ConfirmScreenAccessor) screen).getCallback(), screen.getTitle(), new TranslationTextComponent("deleteworldstotrash.selectWorld.deleteWarning", ((TranslationTextComponent) ((ConfirmScreenAccessor) screen).getTitle2()).getArgs()[0], hasRecycleBin() ? RECYCLE_BIN_COMPONENT : TRASH_COMPONENT), new TranslationTextComponent("deleteworldstotrash.selectWorld.deleteButton", hasRecycleBin() ? RECYCLE_BIN_BUTTON_COMPONENT : TRASH_BUTTON_COMPONENT), DialogTexts.GUI_CANCEL));
            }
        }
    }

    private static boolean hasRecycleBin() {
        return Util.getPlatform() == Util.OS.WINDOWS;
    }
}
