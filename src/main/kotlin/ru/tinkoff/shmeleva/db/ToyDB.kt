package ru.tinkoff.shmeleva.db

import javax.persistence.*

@Table(name = "toys")
@Entity
data class ToyDB(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toy_id")
    var toy_id: Int? = null,

    @Column(name = "toyname")
    val toyname: String,

    @Column(name = "toytype")
    val toytype: String,

    @Column(name = "price")
    val price: Int
)