package com.stringconcat.people.presentation.view

import kotlinx.html.FormMethod
import kotlinx.html.body
import kotlinx.html.dateInput
import kotlinx.html.div
import kotlinx.html.form
import kotlinx.html.h1
import kotlinx.html.html
import kotlinx.html.p
import kotlinx.html.stream.appendHTML
import kotlinx.html.submitInput
import kotlinx.html.textInput
import java.lang.StringBuilder

fun personDetailsForm() =
    StringBuilder()
        .appendHTML()
        .html {
            bootstrapHeader()
            body {
                div(classes = "header") {
                    h1 { +"Create a new person" }
                }
                div("body") {
                    form(action = "/generate", method = FormMethod.post) {
                        p { +"First name " }; textInput(name = "firstName")
                        p { +"Last name " }; textInput(name = "secondName")
                        p { +"Birthdate " }; dateInput(name = "birthDate")
                        p { +"Gender " }; textInput(name = "gender")
                        p { +"" }; submitInput()
                    }
                }
            }
        }.toString()