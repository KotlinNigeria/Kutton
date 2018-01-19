/*
 * Copyright 2016-2018 Andres Almiray
 *
 * This file is part of Griffon Examples
 *
 * Griffon Examples is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Griffon Examples is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Griffon Examples. If not, see <http://www.gnu.org/licenses/>.
 */
package sample.javafx.kotlin

import griffon.javafx.test.FunctionalJavaFXRunner
import griffon.javafx.test.GriffonTestFXClassRule
import javafx.scene.Node
import org.junit.ClassRule
import org.junit.Test
import org.junit.runner.RunWith

import org.testfx.api.FxAssert.verifyThat
import org.testfx.matcher.control.LabeledMatchers.hasText

@RunWith(FunctionalJavaFXRunner::class)
class SampleFunctionalTest {
    companion object {
        init {
            System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "trace")
            System.setProperty("griffon.full.stacktrace", "true")
        }

        @ClassRule @JvmField
        val testfx = GriffonTestFXClassRule("mainWindow")
    }

    @Test
    fun _01_doNotTypeNameAndClickButton() {
        // given:
        testfx.clickOn("#input").write("")

        // when:
        testfx.clickOn("#sayHelloActionTarget")

        // then:
        verifyThat<Node>("#output", hasText("Howdy stranger!"))
    }

    @Test
    fun _02_typeNameAndClickButton() {
        // given:
        testfx.clickOn("#input").write("Griffon")

        // when:
        testfx.clickOn("#sayHelloActionTarget")

        // then:
        verifyThat<Node>("#output", hasText("Hello Griffon"))
    }
}