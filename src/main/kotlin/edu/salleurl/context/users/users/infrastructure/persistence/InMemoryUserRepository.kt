package edu.salleurl.context.users.users.infrastructure.persistence

import edu.salleurl.context.users.users.domain.User
import edu.salleurl.context.users.users.domain.UserRepository
import edu.salleurl.context.users.users.domain.Users
import javax.inject.Named

@Named
class InMemoryUserRepository : UserRepository {

    var users = mutableListOf<User>()

    override fun save(user: User) {
        users.add(user)
    }

    override fun all() = Users(users)
}