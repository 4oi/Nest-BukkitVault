package jp.llv.nest.mod.vault

import jp.llv.nest.command.Context
import jp.llv.nest.command.Func
import jp.llv.nest.command.exceptions.CommandException
import jp.llv.nest.command.obj.NestBool
import jp.llv.nest.command.obj.NestDecimal
import jp.llv.nest.command.obj.bukkit.BukkitPlayer
import net.milkbowl.vault.economy.Economy
import org.bukkit.Server

/**
 * Created by toyblocks on 2016/05/14.
 */
class EconFunc(val bukkit :Server, val econ: Economy) {

    @Func(value = "return economy valance of <player>", perm = "econ.balance")
    fun bal(context: Context<*>,
            player: BukkitPlayer): NestDecimal {
        return NestDecimal(econ.getBalance(player.unwrap()))
    }

    @Func(name = "has?", value = "return if <player> has economy balance <balance>", perm = "econ.has")
    fun has(context: Context<*>,
            player: BukkitPlayer, balance: NestDecimal): NestBool? {
        return NestBool.of(econ.has(player.unwrap(), balance.unwrap()))
    }

    @Func(value = "deposit <balance> in <player>", perm = "econ.deposit")
    fun deposit(context: Context<*>,
            player: BukkitPlayer, balance: NestDecimal): NestBool? {
        val res = econ.depositPlayer(player.unwrap(), balance.unwrap())
        if (res.transactionSuccess()) {
            return NestBool.TRUE
        } else {
            throw CommandException(res.errorMessage)
        }
    }

    @Func(value = "withdraw <balance> from <player>", perm = "econ.withdraw")
    fun withdraw(context: Context<*>,
                player: BukkitPlayer, balance: NestDecimal): NestBool? {
        val res = econ.withdrawPlayer(player.unwrap(), balance.unwrap())
        if (res.transactionSuccess()) {
            return NestBool.TRUE
        } else {
            throw CommandException(res.errorMessage)
        }
    }

}