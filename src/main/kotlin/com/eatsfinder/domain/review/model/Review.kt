package com.eatsfinder.domain.review.model

import com.eatsfinder.domain.category.model.Category
import com.eatsfinder.domain.comment.model.Comment
import com.eatsfinder.domain.shop.model.Shop
import com.eatsfinder.domain.starRating.model.StarRating
import com.eatsfinder.domain.user.model.User
import com.eatsfinder.global.entity.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "reviews")
class Review(

    @Column(name = "name", length = 100)
    val name: String,

    @Column(name = "image_url", nullable = false, columnDefinition = "TEXT")
    val imageUrl: String,

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    val address: String,

    @Column(name = "content", columnDefinition = "TEXT")
    val content: String,

    @Column(name = "shop_tag", columnDefinition = "TEXT")
    val shopTag: String,

    @Column(name = "like_count")
    val likeCount: Int = 0,

    @Column(name = "is_owner", nullable = false, columnDefinition = "TINYINT(1)")
    val isOwner: Boolean,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val userId: User,

    @ManyToOne
    @JoinColumn(name = "shop_id")
    val shopId: Shop,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val categoryId: Category,

    @ManyToOne
    @JoinColumn(name = "rating_id", nullable = false)
    val ratingId: StarRating,

    @OneToMany(mappedBy = "reviewId", cascade = [CascadeType.ALL], orphanRemoval = true)
    var comments: MutableList<Comment> = mutableListOf()

) : BaseTimeEntity()  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}