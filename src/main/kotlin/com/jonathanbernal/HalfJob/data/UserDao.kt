package com.jonathanbernal.HalfJob.data

import org.springframework.data.repository.CrudRepository

interface UserDao : CrudRepository<User, Long>