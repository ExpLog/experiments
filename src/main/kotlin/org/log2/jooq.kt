package org.log2

import kotlinx.coroutines.*
import org.jooq.Result
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.log2.jooq.model.Tables.ACTOR
import org.log2.jooq.model.tables.records.ActorRecord
import java.sql.DriverManager

fun main(args: Array<String>) {
    val username = "postgres"
    val password = "postgres"
    val url = "jdbc:postgresql://127.0.01:5432/dvdrental"

    try {
        val connection = DriverManager.getConnection(url, username, password)

        val create = DSL.using(connection, SQLDialect.POSTGRES_10)
        val result: Result<ActorRecord> = create.selectFrom(ACTOR).fetch()
        println(result[0].javaClass)
        println("Result: $result")

        val result2 =
            create.select(ACTOR.FIRST_NAME.concat(" ").concat(ACTOR.LAST_NAME).`as`("name")).from(ACTOR).fetch()
        println(result2[0].javaClass)
        println("Result: $result2")

    } catch (e: Exception) {
        e.printStackTrace()
    }


    print(usingCoroutinesAsync())
}

fun `this is a function with spaces`() {
    println("asdf")
}

suspend fun suspendExample(): Int = withContext(Dispatchers.Default) {
    for (i in 1..10000) {
        println(i)
        if (i == 500) {
            return@withContext i
        }
    }

    -1
}

fun usingCoroutinesAsync() = GlobalScope.async {
    val a = async { suspendExample() }
    return@async a
}