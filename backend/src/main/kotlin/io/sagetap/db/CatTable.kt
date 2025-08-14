package io.sagetap.db

import org.ktorm.database.Database
import org.ktorm.schema.Table

import org.ktorm.entity.Entity
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface Cat : Entity<Cat> {
    val id: Int
    var name: String
    var breed: String
    var age: Int
    var url: String?
}

object Cats : Table<Cat>("cats") {
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val breed = varchar("breed").bindTo { it.breed }
    val age = int("age").bindTo { it.age }
    val url = varchar("url").bindTo { it.url }
}

object DatabaseConfig {
    lateinit var database: Database

    fun init(
        url: String = "jdbc:postgresql://localhost:5442/sagetap_test",
        user: String = "sagetap",
        password: String = "sagetap_123"
    ) {
        database = Database.connect(
            url = url,
            driver = "org.postgresql.Driver",
            user = user,
            password = password
        )
    }
}