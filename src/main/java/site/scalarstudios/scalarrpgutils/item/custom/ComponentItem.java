package site.scalarstudios.scalarrpgutils.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ComponentItem extends Item {
    private final int level;

    public ComponentItem(int level) {
        super(new Properties());
        this.level = level;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        String tooltipKey = "tooltip.scalarrpgutils.item.component_level_" + level;
        tooltipComponents.add(Component.translatable(tooltipKey).withStyle(ChatFormatting.GRAY));
    }

}
