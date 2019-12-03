package org.log2.serialization

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule


class YamlParser : Parser() {
    override val factory = YAMLFactory()
    override val mapper = ObjectMapper(factory)

    init {
        mapper.registerModule(KotlinModule())
    }
}