package edu.salleurl.context.users.users.domain

interface UserRepository {
    fun save(user: User)
    fun all(): Users
}