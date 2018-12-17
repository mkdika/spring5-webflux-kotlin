package com.mkdika.springwebfluxkotlin.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

@Configuration
class PostRouters(private val postHandler: PostHandler) {

    /*
    Create routes mapping between endpoint and action handler with Router Function DSL
     */
    @Bean
    fun postRouter() = router {
        (accept(APPLICATION_JSON)).nest {

            "/posts".nest {
                GET("/",postHandler::findAllPost)
                GET("/{id}",postHandler::findPostById)
                (POST("/") or PUT("/{id}")).invoke(postHandler::saveOrUpdatePost)
                DELETE("/{id}",postHandler::deletePostById)
            }
        }
    }
}