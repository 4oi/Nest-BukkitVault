package jp.llv.nest.mod.vault

import jp.llv.nest.NestAPIBukkit
import jp.llv.nest.mod.kotlin.KotlinModule
import jp.llv.nest.module.Module
import net.milkbowl.vault.economy.Economy
import org.bukkit.Server

/**
 * Created by toyblocks on 2016/05/14.
 */
@Module(name = "vault", author="toyblocks", version = 1)
class VaultModule(val api: NestAPIBukkit, val bukkit: Server,  val econ: Economy, kotlin: KotlinModule) {

    init {
        api.registerFunc(VaultFunc(bukkit, econ))
    }

}