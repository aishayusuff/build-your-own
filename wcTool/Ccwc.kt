import java.io.File
import java.nio.charset.Charset

fun main (args: Array<String>) {

    try {
        //Checks that args exist
        if (args.isEmpty()) {
            println("This program requires at least one argument!")
        }

        //checks length of args to use apt index
        val file = File(args[(if (args.size > 1) 1 else 0)])

        //checks that file exists and is valid
        if (!file.exists() && !file.isFile()) {
            println("This program requires a valid file path")
        }

        when (args[0]) {
            //command that outputs bytes of a file
            "-c" -> {
                 val numOfBytesInFile = file.length()
                println("This file ($file) has $numOfBytesInFile bytes")
            }
            //command that outputs num of lines in a file
            "-l" -> {
                val numOfLines = file.readLines().size
                println("This file $file contains $numOfLines lines");
            }
            //command that outputs num of words in a file
            "-w" -> {
                val words = (file.readText()).split(Regex("\\s+"))
                val wordCount = words.count { it.isNotBlank() }
                println("This file $file contains $wordCount words")
            }
            //command that outputs the number of characters in a file.
            "-m" -> {
                val numOfChars = file.readText(Charset.forName("UTF-8")).length
                println("This file $file contains $numOfChars numbers of characters")
            }
            //when no command is given
            file.toString() -> {
                println("This file $file contains ${file.readLines().size} lines and ${
                    file.readText().split(Regex("\\s+")).count { it.isNotBlank() }
                } words and has ${file.length()} bytes ")
            }
            else -> {
                println("Please enter a valid command")            }
        }
    } catch (e: Exception) {
        println("${e.message}")
    }
}