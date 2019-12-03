package org.log2.serialization

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File
import java.io.InputStream

abstract class Parser {
    abstract val factory: JsonFactory
    abstract val mapper: ObjectMapper

    inline fun <reified T> parse(inputStream: InputStream): T {
        return mapper.readValue<T>(inputStream).also { inputStream.close() }
    }

    inline fun <reified T> parse(contents: String): T {
        return mapper.readValue(contents)
    }

    inline fun <reified T> parseFile(file: File): T {
        return mapper.readValue(file)
    }
}