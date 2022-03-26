package br.com.monktec.configuration

import br.com.monktec.model.User
import br.com.monktec.repository.UserRepository
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class StartupService(private val userRepository: UserRepository) {

    private val log = LoggerFactory.getLogger(StartupService::class.java)

    @EventListener
    fun onStartupEvent(event: StartupEvent) {
        var user = userRepository.saveEncoded(User(
              38495895869,
              "teste"
        ))

        log.info("Usuário adicionado: {$user}")
    }
}