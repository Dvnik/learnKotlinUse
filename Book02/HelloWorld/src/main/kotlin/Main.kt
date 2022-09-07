fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    var stringArray = arrayOf("a", "b", "c")
    for (i in (1..10).reversed()) {
        println("$i")
    }
    for (i in 10.downTo(1)) {
        println("$i")
    }

    var testNullable:Int?
    if (val a = testNullable!) {
        println("$a")
    }
}
