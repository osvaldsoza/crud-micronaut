package br.com.monktec.configuration.security

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.inject.Singleton

@Singleton
class BCryptPasswordEncorderService : PasswordEncoder {

    private val bCryptEnconder = BCryptPasswordEncoder()
    override fun encode(rawPassword: CharSequence?): String {
        return bCryptEnconder.encode(rawPassword)
    }

    override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
       return bCryptEnconder.matches(rawPassword, encodedPassword)
    }

}