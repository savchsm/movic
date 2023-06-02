package com.savchsm.movic.data.common

import com.savchsm.movic.data.storage.model.ProfileDTO
import com.savchsm.movic.domain.models.Profile

fun ProfileDTO.toProfile() = Profile(
    id = this.id,
    name = this.name.orEmpty(),
    surname = this.surname.orEmpty(),
    image = this.image.orEmpty(),
    email = this.email.orEmpty()
)

fun Profile.toProfileDTO() = ProfileDTO(
    id = this.id,
    name = this.name,
    surname = this.surname,
    image = this.image,
    email = this.email
)