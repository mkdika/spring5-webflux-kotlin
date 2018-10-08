package com.mkdika.springwebfluxkotlin.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class PostRouters(private val postHandler: PostHandler) {

    /*
    Create routes mapping between endpoint and action handler with Router Function DSL
     */
    @Bean
    fun postRouter() = router {
        (accept(MediaType.APPLICATION_JSON)).nest {
            (GET("/posts")).invoke(postHandler::findAllPost)
            (GET("/posts/{id}")).invoke(postHandler::findPostById)
            (POST("/posts/") or PUT("/posts/{id}")).invoke(postHandler::saveOrUpdatePost)
            (DELETE("/posts/{id}")).invoke(postHandler::deletePostById)
        }
    }

}