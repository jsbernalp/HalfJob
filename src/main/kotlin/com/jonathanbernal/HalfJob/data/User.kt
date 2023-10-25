package com.jonathanbernal.HalfJob.data

import com.jonathanbernal.HalfJob.controller.dto.UserDto
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "users")
data class User(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        var name: String,
        var email: String,
        var created: Date
) {
    constructor() : this(null, "", "", Date())
    constructor(userDto: UserDto) : this(null, userDto.name, userDto.email, Date())
}