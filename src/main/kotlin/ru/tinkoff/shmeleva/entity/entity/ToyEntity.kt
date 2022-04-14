package ru.tinkoff.shmeleva.entity.entity

import javax.persistence.*

@Table(name = "toys")
@Entity
data class ToyEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "type")
    val type: String,

    @Column(name = "price")
    val price: Int
)