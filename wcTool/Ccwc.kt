import java.io.File

fun main (args: Array<String>) {
    //Check that the args are 2
    //Check that the first arg is the cmd: -c
    //check that the file exists
    //Get and output the number of bytes

    try {
//        if(args.size != 2 || args[0] != "-c" && args[0] != "-l" && args[0] != "-w") {
//            println("This program requires two arguments; the first arg is cmd '-c' or '-l' or '-w', and the second arg is the file name")
//        }

        //checks that file exists and is valid
        val file = File(args[1]);
        if (!file.exists() && !file.isFile()) {
            println("This program requires a valid file path")
        }

        when (args[0]) {
            //command that outputs bytes of file
            "-c" -> {
                val numOfBytesInFile = file.length()
                println("This file ($file) has $numOfBytesInFile bytes")
            }
            //command that outputs num of lines in the file
            "-l" -> {
                val numOfLines = file.readLines().size
                println("This file $file contains $numOfLines lines");
            }
            //command that outputs num of words in the file
            "-w" -> {
                val words = (file.readText()).split(Regex("\\s+"))
                val wordCount = words.count { it.isNotBlank() }
                println("This file $file contains $wordCount words")
            }
            else -> {
                println("Please enter a valid command")
            }
        }
    } catch (e: Exception) {
        println("${e.message}")
    }
}