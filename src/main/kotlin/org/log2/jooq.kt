package org.log2

import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.log2.jooq.model.Tables.ACTOR
import java.sql.DriverManager

fun main(args: Array<String>) {
    val username = "postgres"
    val password = "postgres"
    val url = "jdbc:postgresql://127.0.01:5432/dvdrental"

    try {
        val connection = DriverManager.getConnection(url, username, password)

        val create = DSL.using(connection, SQLDialect.POSTGRES_10)
        val result = create.select().from(ACTOR).fetch()
        println("Result: $result")

    } catch (e: Exception) {
        e.printStackTrace()
    }
}

