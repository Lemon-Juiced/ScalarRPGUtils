package site.scalarstudios.scalarrpgutils.item.curios;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class AbstractCurioItem extends Item implements ICurioItem {
    private final String resource;
    private final int level;

    public AbstractCurioItem(String resource, int level) {
        super(new Item.Properties().stacksTo(1));
        this.resource = resource;
        this.level = level;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        String tooltipKey = "tooltip.scalarrpgutils.item." + resource + "_level_" + level;
        tooltipComponents.add(Component.translatable(tooltipKey).withStyle(ChatFormatting.GRAY));
    }

    /**
     * Logic:
     * Check if the player currently has the buff provided by the resource and if that buff is of the correct level.
     * If the player does not have the buff, apply it at the correct level.
     * If the player has the buff, upgrade it to the correct level.
     *
     * Different resources map to different effects:
     * - "copper" -> Water Breathing and Dolphin's Grace while swimming
     * - "diamond" -> Regeneration
     * - "emerald" -> Absorption + remove negative effects
     * - "gold" -> Speed (Movement Speed)
     * - "lapis" / "lapis_lazuli" -> Strength (Damage Boost)
     * - "netherite" -> Fire Resistance & Strength + extinguish fire
     * - "quartz" -> Jump Boost
     * - "redstone_crystal" -> Haste
     *
     * The buff is refreshed while the Curio is worn.
     *
     * @param slotContext The Curios slot context containing the entity wearing this curio and slot information.
     * @param stack The ItemStack representing this ring curio.
     */
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        Entity entity = slotContext.entity();
        if (!(entity instanceof Player)) {
            return; // nothing to do if the wearer isn't a player
        }
        Player player = (Player) entity;

        String key = resource == null ? "" : resource.toLowerCase();
        Holder<net.minecraft.world.effect.MobEffect> effectToApply1 = null;
        Holder<net.minecraft.world.effect.MobEffect> effectToApply2 = null;

        switch (key) {
            case "copper":
                effectToApply1 = MobEffects.WATER_BREATHING;
                break;
            case "diamond":
                effectToApply1 = MobEffects.REGENERATION;
                break;
            case "emerald":
                effectToApply1 = MobEffects.ABSORPTION;
                break;
            case "gold":
                effectToApply1 = MobEffects.MOVEMENT_SPEED;
                break;
            case "lapis_lazuli":
                effectToApply1 = MobEffects.DAMAGE_BOOST;
                break;
            case "netherite":
                effectToApply1 = MobEffects.FIRE_RESISTANCE;
                effectToApply2 = MobEffects.DAMAGE_BOOST;
                break;
            case "quartz":
                effectToApply1 = MobEffects.JUMP;
                break;
            case "redstone_crystal":
                effectToApply1 = MobEffects.DIG_SPEED;
                break;
        }

        // Additional Checks for specific resources
        if ("copper".equals(key)) {
            if (player.isSwimming()){
                effectToApply2 = MobEffects.DOLPHINS_GRACE;
            }
        }
        if ("emerald".equals(key)) {
            // Remove any effect classified as harmful
            for (MobEffectInstance effectInstance : player.getActiveEffects()) {
                Holder<net.minecraft.world.effect.MobEffect> holder = effectInstance.getEffect();
                if (holder.value().getCategory() == MobEffectCategory.HARMFUL) {
                    player.removeEffect(holder);
                }
            }
        } else if ("netherite".equals(key)) {
            // Clear Fire
            if (player.isOnFire()) {
                player.extinguishFire();
            }

        }

        if (effectToApply1 != null) {
            int targetAmplifier = Math.max(0, level - 1); // Convert human level to zero-based amplifier
            ensureEffectAtOrAbove(player, effectToApply1, targetAmplifier);
        }

        if (effectToApply2 != null) {
            int targetAmplifier = Math.max(0, level - 1); // Convert human level to zero-based amplifier
            ensureEffectAtOrAbove(player, effectToApply2, targetAmplifier);
        }

        ICurioItem.super.curioTick(slotContext, stack);
    }

    /**
     * Apply or upgrade the given effect so the player has at least the target amplifier.
     *
     * @param player The player to apply the effects to
     * @param effectHolder Holder for the MobEffect
     * @param targetAmplifier The level of amplification of the effect
     */
    private void ensureEffectAtOrAbove(Player player, Holder<net.minecraft.world.effect.MobEffect> effectHolder, int targetAmplifier) {
        MobEffectInstance current = player.getEffect(effectHolder);
        if (current == null || current.getAmplifier() < targetAmplifier) {
            int ticksPerSecond = 20;
            int durationTicks = 5 * ticksPerSecond; // Make duration 5 seconds, this reduces flickering in inventory
            boolean ambient = false;
            // Intended false, true for debug
            boolean showParticles = false;
            boolean showIcon = false;
            // boolean showParticles = true;
            // boolean showIcon = true;

            MobEffectInstance toApply = new MobEffectInstance(effectHolder, durationTicks, targetAmplifier, ambient, showParticles, showIcon);
            player.addEffect(toApply);
        }
    }
}
