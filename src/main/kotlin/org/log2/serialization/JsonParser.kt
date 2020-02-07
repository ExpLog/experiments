package org.log2.serialization

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule

class JsonParser : Parser() {
    override val factory = JsonFactory()
    override val mapper: ObjectMapper =
        ObjectMapper(factory).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)

    init {
        mapper.registerModule(KotlinModule())
        mapper.registerModule(JavaTimeModule())
    }
}