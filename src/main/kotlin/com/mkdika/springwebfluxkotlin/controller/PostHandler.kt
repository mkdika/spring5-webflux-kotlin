package com.mkdika.springwebfluxkotlin.controller

import com.mkdika.springwebfluxkotlin.model.Post
import com.mkdika.springwebfluxkotlin.repository.PostRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class PostHandler(private val postRepository: PostRepository) {

    fun findAllPost(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(postRepository.findAll(), Post::class.java)
                    .switchIfEmpty(ServerResponse.noContent().build())

    fun findPostById(request: ServerRequest): Mono<ServerResponse> {
        val postId:Int = request.pathVariable("id").toInt()
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(postRepository.findById(postId), Post::class.java)
                .switchIfEmpty(ServerResponse.notFound().build())
    }

    fun saveOrUpdatePost(request: ServerRequest): Mono<ServerResponse> =
            request.bodyToMono(Post::class.java).flatMap {ServerResponse.ok().body(fromObject(postRepository.save(it)))}

    fun deletePostById(request: ServerRequest): Mono<ServerResponse> {
        val postId:Int = request.pathVariable("id").toInt()
        return ServerResponse.noContent()
                .build(postRepository.deleteById(postId))
                .switchIfEmpty(ServerResponse.notFound().build())
    }

}