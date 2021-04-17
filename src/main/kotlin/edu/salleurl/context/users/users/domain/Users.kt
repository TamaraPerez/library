package edu.salleurl.context.users.users.domain

data class Users(val list: List<User>) {
   fun count() = list.size
}
