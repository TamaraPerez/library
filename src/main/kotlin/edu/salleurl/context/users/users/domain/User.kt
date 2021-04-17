package edu.salleurl.context.users.users.domain

import edu.salleurl.context.shared.domain.aggregate.AggregateRoot

@AggregateRoot
data class User(val id: UserId, val email: Email)