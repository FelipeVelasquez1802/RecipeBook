package com.test.empowerment.labs.recipebook.recipe.model

import com.test.empowerment.labs.recipebook.R

data class BodyError constructor(
    val title: Int = R.string.error_bad_id_title,
    val description: Int = R.string.error_bad_id_description
)