package com.eatsfinder.domain.comment.model

import jakarta.persistence.*

@Entity
@Table(name = "comments")
class Comment(

    @Column(name = "content")
    val content: String

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}