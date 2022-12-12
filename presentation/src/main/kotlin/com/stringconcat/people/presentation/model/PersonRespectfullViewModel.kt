package com.stringconcat.people.presentation.model

import com.stringconcat.people.businessPeople.Person
import com.stringconcat.people.businessPeople.Person.Sex.MAN
import com.stringconcat.people.businessPeople.Person.Sex.WOMAN

class PersonRespectfullViewModel(
    private val person: Person
) {

    fun title() = "${prefixIfNeeded()} ${person.firstName} ${person.secondName}"

    private fun prefixIfNeeded() =
        if (person.mature())
            when (person.sex) {
                MAN -> "Mr"
                WOMAN -> "Mrs"
            }
        else ""

    fun avatarUrl() = person.avatartUrl

    fun birthDate() = "${person.birthDate.dayOfMonth} ${person.birthDate.month} ${person.birthDate.year}"

    fun favoriteQuote() = person.favoriteQuote
}