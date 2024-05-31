package com.eatsfinder.domain.starRating.model

import com.eatsfinder.domain.review.model.Review
import com.eatsfinder.domain.shop.model.Shop
import com.eatsfinder.domain.user.model.User
import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(name = "star_ratings")
class StarRating(

    @Column(name = "star")
    val star: Float,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    val userId: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    val shopId: Shop,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    val reviewId: Review


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}