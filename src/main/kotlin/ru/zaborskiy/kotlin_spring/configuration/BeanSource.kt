package ru.zaborskiy.kotlin_spring.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.zaborskiy.kotlin_spring.application.service.VirtualSQL

@Configuration
class BeanSource {

    @Bean
    fun aircraftDAO(): VirtualSQL{
        return VirtualSQL()
    }
}