package site.scalarstudios.scalarrpgutils.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class ComponentItem extends Item {
    private final int level;

    public ComponentItem(Properties properties, int level) {
        super(properties);
        this.level = level;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
        String tooltipKey = "tooltip.scalarrpgutils.item.component_level_" + level;
        tooltipAdder.accept(Component.translatable(tooltipKey).withStyle(ChatFormatting.GRAY));
    }

}
