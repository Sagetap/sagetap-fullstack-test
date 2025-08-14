package io.sagetap.db

import kotlinx.serialization.Serializable

@Serializable
data class CatResponse(
    val id: Int,
    val name: String,
    val breed: String,
    val age: Int,
    val url: String? = null
)

fun Cat.toResponse(): CatResponse = CatResponse(
    id = this.id,
    name = this.name,
    breed = this.breed,
    age = this.age,
    url = this.url
)
