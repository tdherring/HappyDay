/**
 * 
 */
package xyz.alicedtrh.happyday;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * @author alice
 *
 */
public class UpgradeableSpawnersDependency {
	boolean upgradeableSpawnersLoaded;

	/**
	 * 
	 */
	public UpgradeableSpawnersDependency() {
		Plugin upgradeableSpawners = Bukkit.getServer().getPluginManager().getPlugin("UpgradeableSpawners");
		if (upgradeableSpawners != null) {
			try {
				if (me.angeschossen.upgradeablespawners.api.UpgradeableSpawnersAPI.class != null) {
					Class.forName("me.angeschossen.upgradeablespawners.api.UpgradeableSpawnersAPI");
					upgradeableSpawnersLoaded = true;
				}
			} catch (ClassNotFoundException ignored) {
				;
			}

			if (!upgradeableSpawnersLoaded) {
				HappyDay.getPlugin(HappyDay.class).getLogger().warning(
						"Unable to load UpgradableSpawnersApi. Compatibility with UpgradeableSpawners is not active.");
			}
		}
	}

	public boolean isSpawnedBySpawner(@NotNull Entity entity) {
		if (upgradeableSpawnersLoaded) {
			return me.angeschossen.upgradeablespawners.api.UpgradeableSpawnersAPI.isSpawnedBySpawner(entity);
		} else {
			return false;
		}
	}

}
