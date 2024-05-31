package com.eatsfinder.domain.shop.model

import com.eatsfinder.domain.category.model.Category
import com.eatsfinder.domain.review.model.Review
import com.eatsfinder.domain.user.model.User
import com.eatsfinder.global.entity.BaseTimeEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "shops")
class Shop(

    @Column(name = "name", nullable = false, length = 100)
    val name: String,

    @Column(name = "address", columnDefinition = "TEXT", nullable = false)
    val address: String,

    @Column(columnDefinition = "JSON")
    val businessHours: String = "{}",

    @Column(name = "telephone", nullable = false, length = 15)
    val telephone: String,

    @Column(name = "menu", columnDefinition = "TEXT")
    val menu: String,

    @Column(name = "image_url", columnDefinition = "TEXT", nullable = false)
    val imageUrl: String,

    @Column(name = "like_count")
    val likeCount: Int = 0,

    @Column(name = "closure", columnDefinition = "TINYINT(1)")
    val closure: Boolean,

    @Column(name = "info", columnDefinition = "TEXT")
    val info: String,

    @Column(name = "is_owner", nullable = false, columnDefinition = "TINYINT(1)")
    val isOwner: Boolean,

    @Column(name = "rating_avg", nullable = false, columnDefinition = "FLOAT(2,1)")
    val ratingAvg: Float,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val userId: User,

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    val categoryId: Category,

    @OneToMany(mappedBy = "shopId", cascade = [CascadeType.ALL], orphanRemoval = true)
    var reviews: MutableList<Review> = mutableListOf()


) : BaseTimeEntity()  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}