import java.io.File
import java.io.FileInputStream
import java.nio.charset.Charset

fun main (args: Array<String>) {
    //helper functions
    fun getNumOfBytes(file: File, fileChunkSize: Int = 1024 * 1024): Long {
        var totalByte: Long = 0

        //read files in increments for scalability
        FileInputStream(file).use { stream ->
            val buffer = ByteArray(fileChunkSize)
            var byteRead: Int

            while (stream.read(buffer).also { byteRead = it } != -1) {
                totalByte += byteRead
            }
        }
        return totalByte
    }

    fun getNumOfLines(file: File): Int {
        return file.readLines().size
    }

    fun getNumOfWords(file: File): Int {
        return file.readText().split(Regex("\\s+")).count{it.isNotBlank()}
    }

    fun getNumOfChars(file: File): Int {
        return file.readText(Charset.forName("UTF-8")).length
    }

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