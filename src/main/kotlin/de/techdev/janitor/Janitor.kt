package de.techdev.janitor

import de.techdev.pocket.api.Pocket
import java.io.PrintStream as Printer

fun main(args: Array<String>): Unit {
    val name: String = "Janitor"
    var version = "0.0.1"

    fun Printer.echo() = "$name v$version"

    println(System.out.echo())

    val items = Pocket.connect("60419-3260c95728889acdc1069407", "daa753a9-f561-f444-66c9-ba4119").retrieveOperations().items()

    items.forEach(::println)
}