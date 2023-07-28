package com.example.core.design

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = openSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = Color.White
    ),
    bodyMedium = TextStyle(
        fontFamily = openSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = openSansFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        color = Color.White
    ),
)