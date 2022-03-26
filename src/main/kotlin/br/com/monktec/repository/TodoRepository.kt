package br.com.monktec.repository

import br.com.monktec.model.Todo
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface TodoRepository: JpaRepository<Todo, Long> {
}