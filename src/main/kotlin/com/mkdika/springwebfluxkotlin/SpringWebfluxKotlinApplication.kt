package com.mkdika.springwebfluxkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class SpringWebfluxKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringWebfluxKotlinApplication>(*args)
}
