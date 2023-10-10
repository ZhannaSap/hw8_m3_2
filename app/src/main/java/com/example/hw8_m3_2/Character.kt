package com.example.hw8_m3_2

import java.io.Serializable

data class Character(
    var image: String? = "Фoто не загрузилось",
    var name:String? = "Имя не загрузилось",
    var phrase: String? = "Фраза не загрузилась"
):Serializable
