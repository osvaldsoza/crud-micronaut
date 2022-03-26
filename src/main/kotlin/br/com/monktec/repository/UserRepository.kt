package br.com.monktec.repository

import br.com.monktec.model.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import org.springframework.security.crypto.password.PasswordEncoder

@Repository
abstract class UserRepository(private val passwordEncoder: PasswordEncoder) : JpaRepository<User, Long> {

    fun saveEncoded(entity: User): User {

        val newUser = User(
                entity.cpf,
                passwordEncoder.encode(entity.password)
        )
        return save(newUser)
    }
}