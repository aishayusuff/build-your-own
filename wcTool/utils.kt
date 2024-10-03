import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.nio.charset.Charset

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

fun getNumOfLines(file: File): Long {
    var lineCount = 0L
    BufferedReader(FileReader(file)).use { reader ->
        val firstLine: String? = reader.readLine();
        while (firstLine != null) {
            lineCount++
            reader.readLine()
        }
    }
    return lineCount;
}

fun getNumOfWords(file: File): Int {
    return file.readText().split(Regex("\\s+")).count{it.isNotBlank()}
}

fun getNumOfChars(file: File): Int {
    return file.readText(Charset.forName("UTF-8")).length
}