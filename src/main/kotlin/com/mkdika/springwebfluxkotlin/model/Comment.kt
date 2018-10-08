package com.mkdika.springwebfluxkotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Comment(
        @Id
        val id: Int = 0,
        val email: String = "",
        val comment: String = "",
        val commentTime: Date = Date()
)