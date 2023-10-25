package com.jonathanbernal.HalfJob.service

import com.jonathanbernal.HalfJob.data.User
import java.util.Optional

interface UserService {
    fun findById(id: Long): Optional<User>
    fun create(user: User): User
    fun all(): Iterable<User>
}