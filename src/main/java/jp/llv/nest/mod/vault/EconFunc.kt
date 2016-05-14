package jp.llv.nest.mod.vault

import jp.llv.nest.command.CommandExecutor
import jp.llv.nest.command.Func
import jp.llv.nest.command.obj.NestBool
import jp.llv.nest.command.obj.NestDecimal
import jp.llv.nest.command.obj.bind.Binding
import jp.llv.nest.command.obj.bukkit.BukkitCommandSender
import jp.llv.nest.command.obj.bukkit.BukkitPlayer
import net.milkbowl.vault.economy.Economy
import org.bukkit.Server
import org.bukkit.command.CommandSender

/**
 * Created by toyblocks on 2016/05/14.
 */
class EconFunc(val bukkit :Server, val econ: Economy) {

    @Func(value = "return economy valance of <player>", perm = "econ.balance")
    fun bal(executor: CommandExecutor, sender: BukkitCommandSender<CommandSender>, binding: Binding<Any>,
            player: BukkitPlayer): NestDecimal {
        return NestDecimal(econ.getBalance(player.unwrap()))
    }

    @Func(name = "has?", value = "return if <player> has economy balance <balance>", perm = "econ.has")
    fun has(executor: CommandExecutor, sender: BukkitCommandSender<CommandSender>, binding: Binding<Any>,
            player: BukkitPlayer, balance: NestDecimal): NestBool {
        return NestBool.of(econ.has(player.unwrap(), balance.unwrap()))
    }

    @Func(value = "deposit <balance> in <player>", perm = "econ.deposit")
    fun deposit(executor: CommandExecutor, sender: BukkitCommandSender<CommandSender>, binding: Binding<Any>,
            player: BukkitPlayer, balance: NestDecimal): NestBool {
        return NestBool.of(econ.depositPlayer(player.unwrap(), balance.unwrap()).transactionSuccess())
    }

    @Func(value = "withdraw <balance> from <player>", perm = "econ.withdraw")
    fun withdraw(executor: CommandExecutor, sender: BukkitCommandSender<CommandSender>, binding: Binding<Any>,
                player: BukkitPlayer, balance: NestDecimal): NestBool {
        return NestBool.of(econ.withdrawPlayer(player.unwrap(), balance.unwrap()).transactionSuccess())
    }

}