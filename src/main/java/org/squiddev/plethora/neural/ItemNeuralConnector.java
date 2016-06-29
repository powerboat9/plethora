package org.squiddev.plethora.neural;

import dan200.computercraft.shared.computer.core.ServerComputer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.squiddev.plethora.GuiHandler;
import org.squiddev.plethora.ItemBase;
import org.squiddev.plethora.Plethora;

public class ItemNeuralConnector extends ItemBase {
	public ItemNeuralConnector() {
		super("neuralConnector", 1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			ItemStack neuralStack = NeuralHelpers.getStack(player);
			if (neuralStack != null) {
				ServerComputer computer = ItemComputerHandler.getServer(neuralStack, player, player.inventory);
				if (computer != null) {
					computer.turnOn();
					player.openGui(Plethora.instance, GuiHandler.GUI_NEURAL, player.worldObj, 0, 0, 0);
				}
			}
		}

		return stack;
	}
}
