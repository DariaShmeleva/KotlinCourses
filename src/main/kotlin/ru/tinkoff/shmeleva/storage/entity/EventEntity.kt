package ru.tinkoff.shmeleva.storage.entity

import ru.tinkoff.shmeleva.util.EventStatus
import ru.tinkoff.shmeleva.util.EventType
import javax.persistence.*


@Table(name = "events")
@Entity
class EventEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    var id: Long? = null,

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    val type: EventType,

    @Column(name = "body")
    val body: String,

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    var status: EventStatus
)