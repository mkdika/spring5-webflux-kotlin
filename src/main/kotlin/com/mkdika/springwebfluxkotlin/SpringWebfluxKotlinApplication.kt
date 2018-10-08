package com.mkdika.springwebfluxkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class SpringWebfluxKotlinApplication

fun main(args: Array<String>) {
    //    runApplication<SpringWebfluxKotlinApplication>(*args)
    val app = SpringApplication(SpringWebfluxKotlinApplication::class.java)
    app.webApplicationType = WebApplicationType.REACTIVE
    app.run(*args)
}
