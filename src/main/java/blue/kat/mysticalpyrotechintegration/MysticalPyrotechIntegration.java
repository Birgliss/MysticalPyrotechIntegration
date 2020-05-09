package blue.kat.mysticalpyrotechintegration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.codetaylor.mc.pyrotech.PyrotechAPI;

import blue.kat.mysticalpyrotechintegration.items.ItemLivingHammer;
import blue.kat.mysticalpyrotechintegration.proxy.Proxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid=MysticalPyrotechIntegration.MODID, name=MysticalPyrotechIntegration.NAME, version=MysticalPyrotechIntegration.VERSION, dependencies=MysticalPyrotechIntegration.DEPENDENCIES)
public class MysticalPyrotechIntegration {
	public static final String MODID = "mysticalpyrotechintegration";
	public static final String NAME = "Mystical Mods - Pyrotech Integration";
	public static final String VERSION = "@VERSION@";
	public static final String DEPENDENCIES = "required-after:pyrotech;";
	
	public static final Logger log = LogManager.getLogger(NAME);
	
	@SidedProxy(clientSide="blue.kat.mysticalpyrotechintegration.proxy.ClientProxy", serverSide="blue.kat.mysticalpyrotechintegration.proxy.ServerProxy")
	public static Proxy proxy;
	
	public static ItemLivingHammer LIVING_HAMMER;
	
	@EventHandler
	public void onPreInit(FMLPreInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(this);
		proxy.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		PyrotechAPI.registerHammer(LIVING_HAMMER, 2);
		proxy.init();
	}
	
	@SubscribeEvent
	public void onRegisterItems(RegistryEvent.Register<Item> e) {
		e.getRegistry().register(LIVING_HAMMER = (ItemLivingHammer) new ItemLivingHammer()
				.setRegistryName("living_hammer").setUnlocalizedName(MODID+".living_hammer")
				.setMaxStackSize(1)
				.setMaxDamage(576)
				.setCreativeTab(CreativeTabs.TOOLS)); //replace later, maybe make our own?
	}
}
