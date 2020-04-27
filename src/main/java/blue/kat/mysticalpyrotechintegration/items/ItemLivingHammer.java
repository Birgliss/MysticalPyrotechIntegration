package blue.kat.mysticalpyrotechintegration.items;

import com.codetaylor.mc.pyrotech.modules.core.item.spi.ItemHammerBase;

import java.util.Collections;

//don't forget to implement ILivingRepair
public class ItemLivingHammer extends ItemHammerBase {
	
	public ItemLivingHammer() {
		//replace material with living later
		super(ToolMaterial.IRON, Collections.emptySet());
	}
}
