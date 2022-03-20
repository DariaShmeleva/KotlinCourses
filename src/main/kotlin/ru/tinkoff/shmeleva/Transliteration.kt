package ru.tinkoff.shmeleva

object Transliteration {
    private fun cyr2latAlphabet(ch: Char): String {
        return when (ch) {
            'А' -> "A"
            'Б' -> "B"
            'В' -> "V"
            'Г' -> "G"
            'Д' -> "D"
            'Е' -> "E"
            'Ё' -> "JE"
            'Ж' -> "ZH"
            'З' -> "Z"
            'И' -> "I"
            'Й' -> "Y"
            'К' -> "K"
            'Л' -> "L"
            'М' -> "M"
            'Н' -> "N"
            'О' -> "O"
            'П' -> "P"
            'Р' -> "R"
            'С' -> "S"
            'Т' -> "T"
            'У' -> "U"
            'Ф' -> "F"
            'Х' -> "H"
            'Ц' -> "C"
            'Ч' -> "CH"
            'Ш' -> "SH"
            'Щ' -> "JSH"
            'Ъ' -> ""
            'Ы' -> "I"
            'Ь' -> ""
            'Э' -> "E"
            'Ю' -> "U"
            'Я' -> "YA"
            'а' -> "a"
            'б' -> "b"
            'в' -> "v"
            'г' -> "g"
            'д' -> "d"
            'е' -> "e"
            'ё' -> "je"
            'ж' -> "zh"
            'з' -> "z"
            'и' -> "i"
            'й' -> "y"
            'к' -> "k"
            'л' -> "l"
            'м' -> "m"
            'н' -> "n"
            'о' -> "o"
            'п' -> "p"
            'р' -> "r"
            'с' -> "s"
            'т' -> "t"
            'у' -> "u"
            'ф' -> "f"
            'х' -> "h"
            'ц' -> "c"
            'ч' -> "ch"
            'ш' -> "sh"
            'щ' -> "jsh"
            'ъ' -> ""
            'ы' -> "i"
            'ь' -> ""
            'э' -> "e"
            'ю' -> "u"
            'я' -> "ya"
            else -> ch.toString()
        }
    }

    fun cyr2lat(s: String): String {
        val sb = StringBuilder(s.length * 2)
        for (ch in s.toCharArray()) {
            sb.append(cyr2latAlphabet(ch))
        }
        return sb.toString()
    }
}