package be.maelbrancke.filip.springkotlindemo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class GotCharacter(val firstName: String,
                        val lastName: String,
                        val age: Int,
                        val actor: String,
                        @Id @GeneratedValue(strategy = GenerationType.AUTO)
                        val id: Long = -1)