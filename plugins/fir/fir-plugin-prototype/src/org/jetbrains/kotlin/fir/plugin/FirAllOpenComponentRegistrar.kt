/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.plugin

import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrar
import org.jetbrains.kotlin.fir.plugin.generators.*

class FirAllOpenComponentRegistrar : FirExtensionRegistrar() {
    override fun ExtensionRegistrarContext.configurePlugin() {
        +::AllOpenStatusTransformer
        +::AllOpenSupertypeGenerator

        // Declaration generators
        +::AllOpenMemberGenerator
        +::AllOpenNestedClassGenerator
        +::AllOpenAdditionalCheckers
        +::AllOpenTopLevelDeclarationsGenerator
        +::AllOpenRecursiveNestedClassGenerator
    }
}