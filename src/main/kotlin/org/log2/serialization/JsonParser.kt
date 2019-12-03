package org.log2.serialization

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.log2.serialization.Parser

class JsonParser : Parser() {
    override val factory = JsonFactory()
    override val mapper = ObjectMapper(factory)

    init {
        mapper.registerModule(KotlinModule())
    }
}