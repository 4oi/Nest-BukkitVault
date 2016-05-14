package jp.llv.nest.mod.vault

import jp.llv.nest.command.Func
import net.milkbowl.vault.economy.Economy
import org.bukkit.Server

/**
 * Created by toyblocks on 2016/05/14.
 */
class VaultFunc(bukkit: Server, econ: Economy) {
    @Func(value = "provide economy functions")
    val econ = EconFunc(bukkit, econ)
}