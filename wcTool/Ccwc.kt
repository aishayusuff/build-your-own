import java.io.File
import java.nio.charset.Charset

fun main (args: Array<String>) {

    try {
        //checks that file exists and is valid
        val file = File(args[1]);
        if (!file.exists() && !file.isFile()) {
            println("This program requires a valid file path")
        }

        var numOfBytesInFile = 0L
        var numOfLines = 0
        var wordCount = 0

        when (args[0]) {
            //command that outputs bytes of a file
            "-c" -> {
                 numOfBytesInFile = file.length()
                println("This file ($file) has $numOfBytesInFile bytes")
            }
            //command that outputs num of lines in a file
            "-l" -> {
                numOfLines = file.readLines().size
                println("This file $file contains $numOfLines lines");
            }
            //command that outputs num of words in a file
            "-w" -> {
                val words = (file.readText()).split(Regex("\\s+"))
                wordCount = words.count { it.isNotBlank() }
                println("This file $file contains $wordCount words")
            }
            //command that outputs the number of characters in a file.
            "-m" -> {
                val numOfChars = file.readText(Charset.forName("UTF-8")).length
                println("This file $file contains $numOfChars numbers of characters")
            }
            else -> {
                println("Please enter a valid command")
            }
        }
    } catch (e: Exception) {
        println("${e.message}")
    }
}