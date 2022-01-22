package fuzs.deleteworldstotrash.mixin.client.accessor;

import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.minecraft.client.gui.screen.ConfirmScreen;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ConfirmScreen.class)
public interface ConfirmScreenAccessor {
    @Accessor
    ITextComponent getTitle2();

    @Accessor
    BooleanConsumer getCallback();
}
