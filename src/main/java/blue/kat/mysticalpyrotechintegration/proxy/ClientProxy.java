package blue.kat.mysticalpyrotechintegration.proxy;

import blue.kat.mysticalpyrotechintegration.MysticalPyrotechIntegration;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy implements Proxy {
	
	@Override
	public void preInit() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onModelRegister(ModelRegistryEvent e) {
		ModelLoader.setCustomModelResourceLocation(MysticalPyrotechIntegration.LIVING_HAMMER, 0, 
				new ModelResourceLocation(MysticalPyrotechIntegration.MODID+":living_hammer#inventory"));
	}
}
