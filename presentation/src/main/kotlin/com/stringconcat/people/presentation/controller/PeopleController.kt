package com.stringconcat.people.presentation.controller

import com.stringconcat.people.presentation.model.PersonRespectfullViewModel
import com.stringconcat.people.presentation.view.personDetailsForm
import com.stringconcat.people.presentation.view.renderDetailedView
import com.stringconcat.people.useCasePeople.CreateNewPersonUseCase
import com.stringconcat.people.useCasePeople.GetPersonUseCase
import com.stringconcat.people.useCasePeople.MeUseCase
import com.stringconcat.people.useCasePeople.PersonCreationSummary
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.UUID

@RestController
class PeopleController(
    val getPerson: GetPersonUseCase,
    val createNew: CreateNewPersonUseCase,
    val getMe: MeUseCase
) {

    @GetMapping("/me")
    fun me(): String {
        return renderDetailedView(person = PersonRespectfullViewModel(getMe()))
    }

    @GetMapping("/id/{id}")
    fun get(@PathVariable id: String): ResponseEntity<String> {
/*
        val idUUD = try {
            UUID.fromString(id)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.badRequest().build()
        }
*/
        val idUUD = UUID.fromString(id)

        val person = getPerson(idUUD)
            ?: return ResponseEntity.badRequest().build()

        return ResponseEntity.ok(
            renderDetailedView(PersonRespectfullViewModel(person))
        )
    }

    @GetMapping("/generate")
    fun showCreationForm(): String {
        return personDetailsForm()
    }

    @PostMapping(
        value = ["/generate"],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE]
    )
    fun create(personInput: PersonCreationSummary): ResponseEntity<String> {
        val generatedPerson = createNew(personInput)

        return ResponseEntity
            .status(HttpStatus.FOUND)
            .location(URI.create("/id/${generatedPerson.id}"))
            .build()
    }
}