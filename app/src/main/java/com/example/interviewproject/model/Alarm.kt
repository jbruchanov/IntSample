package com.example.interviewproject.model

data class Alarm(val time: String = "12:00", var enabled: Boolean = true) {
    fun days(): String = "M T W"
}