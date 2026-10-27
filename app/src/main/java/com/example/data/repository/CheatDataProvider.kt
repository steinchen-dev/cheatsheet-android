package com.example.data.repository

import com.example.data.model.CheatCategory

/**
 * Zentrale Bereitstellung aller 21 CheatSheet-Kategorien.
 * Inklusive "IT-Lexikon" (36 TL;DR Erklärungen) und "Power-Tools" (105 handverlesene Tools).
 * Insgesamt über 730+ strukturierte Einträge.
 */
object CheatDataProvider {

    val allCategories: List<CheatCategory> = 
        officeCategories +
        linuxCategories +
        devCategories +
        devOpsCategories +
        knowledgeCategories +
        toolsCategories
}
