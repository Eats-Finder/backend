package com.eatsfinder.domain.user.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "name")
    val name: String,

    @Column(name = "nickname")
    val nickname: String,

    @Column(name = "profile_image")
    val profileImage: String,

    @Column(name = "phone_number")
    val phoneNumber: String,

    @Column(name = "follow_count")
    val followCount: Int,

    @Column(name = "role")
    val role: UserRole,

    @Column(name = "status")
    val status: UserStatus,

    @Column(name = "social_type")
    val socialType: SocialType

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}