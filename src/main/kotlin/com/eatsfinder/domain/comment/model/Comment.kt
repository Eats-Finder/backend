package com.eatsfinder.domain.comment.model

import com.eatsfinder.domain.review.model.Review
import com.eatsfinder.domain.user.model.User
import jakarta.persistence.*

@Entity
@Table(name = "comments")
class Comment(

    @Column(name = "content", columnDefinition = "TEXT")
    val content: String,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val userId: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    val reviewId: Review

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}