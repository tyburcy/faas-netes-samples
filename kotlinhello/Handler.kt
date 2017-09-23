import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader



fun main(args : Array<String>) { 
  val input = readStdin()
  println("Hello in Faas-netes " + input.toUpperCase()) 
}

private fun readStdin(): String {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var input = ""
        while (true) {
            val line = br.readLine() ?: break
            input = input + line + "\n"
        }
        return input
    }
