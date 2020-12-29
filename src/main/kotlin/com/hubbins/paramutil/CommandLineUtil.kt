package com.hubbins.paramutil

import java.lang.NumberFormatException


fun param(name: String, defaultValue: String?, args: Array<String>): String? {
    var retval = defaultValue

    for (arg: String in args) {
        if (arg.decapitalize().startsWith("/" + name.decapitalize() + ":")) {
            retval = arg.substring(arg.indexOf(':') + 1)
            break
        }
    }

    return retval
}

fun param(name: String, defaultValue: Int, args: Array<String>): Int {
    var retval = defaultValue

    for (arg: String in args) {
        if (arg.decapitalize().startsWith("/" + name.decapitalize() + ":")) {
            val paramValue = arg.substring(arg.indexOf(':') + 1)
            try {
                retval = paramValue.toInt()
            } catch (e: NumberFormatException) {
                println("Not an integer: ${paramValue}")
            }

            break
        }
    }

    return retval
}

fun param(name: String, args: Array<String>): Boolean {
    for (arg: String in args) {
        if (arg.decapitalize().equals("/" + name.decapitalize()))
            return true
    }

    return false
}
