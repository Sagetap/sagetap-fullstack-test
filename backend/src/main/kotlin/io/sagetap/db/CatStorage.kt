package io.sagetap.db

import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class CatsStorage(private val database: Database) {

    private val cats get() = database.sequenceOf(Cats)

    fun getAll(): List<Cat> {
        return cats.toList()
    }
}