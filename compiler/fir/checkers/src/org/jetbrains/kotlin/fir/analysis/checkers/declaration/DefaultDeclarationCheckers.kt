/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.analysis.checkers.declaration

import org.jetbrains.kotlin.fir.analysis.cfa.FirPropertyInitializationAnalyzer
import org.jetbrains.kotlin.fir.analysis.checkers.cfa.FirControlFlowChecker

object CommonDeclarationCheckers : DeclarationCheckers() {
    override val declarationCheckers: List<FirBasicDeclarationChecker> = listOf(
        FirAnnotationClassDeclarationChecker,
        FirModifierChecker,
        FirManyCompanionObjectsChecker,
        FirLocalEntityNotAllowedChecker,
        FirTypeParametersInObjectChecker,
    ) + ExtendedDeclarationCheckers.declarationCheckers

    override val memberDeclarationCheckers: List<FirMemberDeclarationChecker> = listOf(
        FirInfixFunctionDeclarationChecker,
        FirExposedVisibilityDeclarationChecker,
    ) + ExtendedDeclarationCheckers.memberDeclarationCheckers

    override val constructorCheckers: List<FirConstructorChecker> = listOf(
        FirConstructorAllowedChecker,
    ) + ExtendedDeclarationCheckers.constructorCheckers

    override val controlFlowAnalyserCheckers: List<FirControlFlowChecker> = listOf(
        FirPropertyInitializationAnalyzer
    ) + ExtendedDeclarationCheckers.controlFlowAnalyserCheckers
}