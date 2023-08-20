package com.example.jm3x.data.model

class User {
    var id: String
    var name: String
    var email: String? = null
    var birth = 0
    private var medals: List<Medal>? = null
    private var traits: String? = null
    var image: String? = null

    constructor(id: String, name: String, email: String?, birth: Int, traits: String?) {
        this.id = id
        this.name = name
        this.email = email
        this.birth = birth
        this.traits = traits
    }

    constructor(
        id: String,
        name: String,
        email: String?,
        birth: Int,
        medals: List<Medal>?,
        traits: String?,
        image: String?
    ) {
        this.id = id
        this.name = name
        this.email = email
        this.birth = birth
        this.medals = medals
        this.traits = traits
        this.image = image
    }

    constructor(
        id: String,
        name: String,
        email: String?,
        birth: Int,
        traits: String?,
        image: String?
    ) {
        this.id = id
        this.name = name
        this.email = email
        this.birth = birth
        this.traits = traits
        this.image = image
    }

    constructor(id: String, name: String) {
        this.id = id
        this.name = name
    }

    fun gettraits(): String? {
        return traits
    }

    fun settraits(traits: String?) {
        this.traits = traits
    }
}