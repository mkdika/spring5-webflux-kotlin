package com.mkdika.springwebfluxkotlin.repository

import com.mkdika.springwebfluxkotlin.model.Post
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PostRepository: ReactiveMongoRepository<Post, Integer>