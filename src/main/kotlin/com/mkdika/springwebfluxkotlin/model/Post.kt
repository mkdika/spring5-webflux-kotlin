package com.mkdika.springwebfluxkotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Post(

        @Id
        val id: Int,
        val title: String,
        val content: String,
        val postTime: Date,
        val Comments: List<Comment>

)