package org.log2.structured.logging

import org.log2.serialization.JsonParser
import java.time.LocalDateTime
import kotlin.reflect.KClass

// this could be easily used to wrap some logging library
// or we could just use the log event and the lambda as an extension function in order to add structured fields!
// for some dumb reason, this is pretty exciting to me
// maybe I could even try to emulate Eliot, a very cool distributed logging module in Python
class Logger(val name: String) {
    constructor(kotlinClass: KClass<*>) : this(kotlinClass.qualifiedName!!)

    fun info(message: String) {
        val datetime = LocalDateTime.now()
        println("[$datetime][INFO] $message")
    }

    fun info(message: String, builder: (LogEvent) -> Unit) {
        val event = LogEvent(message, "INFO", name)
        builder(event)
        printLogEvent(event)
    }

    fun info(message: String, vararg attributes: Pair<String, Any>) {
        val event = LogEvent(message, "INFO", name)
        for (entry in attributes) {
            event[entry.first] = entry.second
        }
        printLogEvent(event)
    }

    // TODO: exception and stacktrace

    private fun printLogEvent(event: LogEvent) {
        val payload = jsonMapper.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(event)
        println(payload)
    }

    companion object Logger {
        private val jsonMapper = JsonParser()
    }
}

class LogEvent(val message: String, val level: String, val loggerName: String) {
    val datetime = LocalDateTime.now()
    val attributes: MutableMap<String, Any> = HashMap()

    operator fun set(attribute: String, value: Any) {
        attributes[attribute] = value
    }

    fun put(attribute: String, value: Any) {
        attributes[attribute] = value
    }
}

data class DummyData(val a: Int, val b: Int)

fun main() {
    val logger = Logger(Logger::class)
    logger.info("this is just an informational message")

    logger.info("json payload") {
        it["something"] = "is working"
        it["another"] = "thing is pretty cool"
        it["data"] = DummyData(1, 2)
    }

    // the pairs are essentially creating a DSL, by using an infix operator 'to'
    logger.info("json payload", "this time" to "using", "pair" to "because", "they are" to "fun")

    val map = mapOf(1 to 2, 2 to 3)

    // this is looking pretty good!
    // I need to try wrapping sl4j and actually writing logs to see what I can do
}