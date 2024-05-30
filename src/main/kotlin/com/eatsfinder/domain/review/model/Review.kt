package com.eatsfinder.domain.review.model

import jakarta.persistence.*

@Entity
@Table(name = "reviews")
class Review(

    @Column(name = "name")
    val name: String,

    @Column(name = "image_url")
    val imageUrl: String,

    @Column(name = "address")
    val address: String,

    @Column(name = "content")
    val content: String,

    @Column(name = "shop_tag")
    val shopTag: String,

    @Column(name = "like_count")
    val likeCount: Int,

    @Column(name = "is_owner")
    val isOwner: Boolean

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}