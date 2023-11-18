package com.example.betterto_do.tasks

import androidx.compose.ui.graphics.Color

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor),
}

val LowPriorityColor = Color(0XFF00C980)
val MediumPriorityColor = Color(0XFFFFC114)
val HighPriorityColor = Color(0XFFFF4646)
val NonePriorityColor = Color.LightGray