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

import griffon.core.artifact.GriffonService
import griffon.metadata.ArtifactProviderFor
import griffon.util.GriffonNameUtils.isBlank
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonService

@ArtifactProviderFor(GriffonService::class)
class SampleService : AbstractGriffonService() {
    fun sayHello(input: String?): String {
        return if (isBlank(input)) {
            application.messageSource.getMessage("greeting.default")
        } else {
            application.messageSource.getMessage("greeting.parameterized", listOf(input))
        }
    }
}