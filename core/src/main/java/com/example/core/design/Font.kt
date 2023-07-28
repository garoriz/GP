package com.example.core.design

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.core.R

val openSansFamily = FontFamily(
    Font(R.font.opensans_light, FontWeight.Light),
    Font(R.font.opensans_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.opensans_regular, FontWeight.Normal),
    Font(R.font.opensans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.opensans_semibold, FontWeight.SemiBold),
    Font(R.font.opensans_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.opensans_bold, FontWeight.Bold),
    Font(R.font.opensans_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.opensans_extrabold, FontWeight.ExtraBold),
    Font(R.font.opensans_extrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),
)