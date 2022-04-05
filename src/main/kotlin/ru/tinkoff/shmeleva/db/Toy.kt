package ru.tinkoff.shmeleva.db

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "toys")
@Entity
data class Toy(

    @Id
    @Column(name = "toy_id")
    var toyId : Int? = null,
    @Column(name = "toyname")
    var toyname : String? = null,
    @Column(name = "toytype")
    var toytype : String? = null,
    @Column(name = "price")
    var price : Int? = null
)