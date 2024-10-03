import java.io.File


fun main (args: Array<String>) {
    try {
        //Checks that args exist
        if (args.isEmpty()) {
            println("This program requires at least one argument!")
            return
        }

        //checks length of args to use apt index
        val file = File(args[(if (args.size > 1) 1 else 0)])

        //checks that file exists and is valid
        if (!file.exists() || !file.isFile()) {
            println("This program requires a valid file path")
            return
        }

        when (args[0]) {
            //command that outputs bytes of a file
            "-c" -> {
                println("This file ($file) has ${getNumOfBytes(file)} bytes")
            }
            //command that outputs num of lines in a file
            "-l" -> {
                println("This file ($file) contains ${getNumOfLines(file)} lines")
            }
            //command that outputs num of words in a file
            "-w" -> {
                println("This file ($file) contains ${getNumOfWords(file)} words")
            }
            //command that outputs the number of characters in a file.
            "-m" -> {
                println("This file ($file) contains ${getNumOfChars(file)} numbers of characters")
            }
            else -> {
                println(
                    "This file ($file) contains ${getNumOfLines(file)} lines and ${getNumOfWords(file)} words and has ${
                        getNumOfBytes(
                            file
                        )
                    } bytes "
                )
            }
        }
    } catch (e: Exception) {
        println("${e.message}")
    }
}