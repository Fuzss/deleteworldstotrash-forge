package fuzs.deleteworldstotrash.mixin.client;

import fuzs.deleteworldstotrash.world.level.storage.WorldTrashUtil;
import net.minecraft.server.SessionLockManager;
import net.minecraft.world.storage.SaveFormat;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.file.Path;

@Mixin(SaveFormat.LevelSave.class)
public abstract class LevelSaveMixin {
    @Shadow
    @Final
    SessionLockManager lock;
    @Shadow
    @Final
    Path levelPath;

    @Shadow
    private void checkLock() {
        throw new IllegalStateException();
    }

    @Inject(method = "deleteLevel", at = @At("HEAD"), cancellable = true)
    public void deleteLevel(CallbackInfo callbackInfo) {
        if (WorldTrashUtil.tryMoveToTrash(this.lock, this.levelPath, this::checkLock)) {
            callbackInfo.cancel();
        }
    }
}
