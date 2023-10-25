package com.jonathanbernal.HalfJob.controller

import com.jonathanbernal.HalfJob.controller.dto.UserDto
import com.jonathanbernal.HalfJob.data.User
import com.jonathanbernal.HalfJob.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("user")
class UserController(@Autowired private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody userDto: UserDto): ResponseEntity<User> {
        return ResponseEntity.ok(userService.create(User(userDto)))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<User> {
        val userOptional = userService.findById(id)
        if (userOptional.isPresent) {
            return ResponseEntity.ok(userOptional.get())
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User with id $id not found")
        }
    }

    @GetMapping("/items")
    fun all(): ResponseEntity<Iterable<User>> {
        return ResponseEntity.ok(userService.all())
    }
}