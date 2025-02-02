package mod.crend.yaclx.fabric;

import mod.crend.yaclx.YaclX;
import net.fabricmc.fabric.api.tag.client.v1.ClientTags;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.util.Set;

@SuppressWarnings("unused")
public class PlatformUtilsImpl {
	public static boolean isYaclLoaded() {
		return FabricLoader.getInstance().isModLoaded(YaclX.YACL_MOD_ID);
	}

	public static Path resolveConfigFile(String configName) {
		return FabricLoader.getInstance().getConfigDir().resolve(configName);
	}

	public static Class<?> getModdedItemTagsClass() {
		return ConventionalItemTags.class;
	}

	public static Set<Identifier> getItemsFromTag(TagKey<Item> itemTagKey) {
		return ClientTags.getOrCreateLocalTag(itemTagKey);
	}
}
