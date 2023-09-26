package com.example.examaugust.response


import com.google.gson.annotations.SerializedName

data class Testimonials(
    @SerializedName("testimonials_data")
    val testimonialsData: List<TestimonialsData>,
    @SerializedName("testimonials_label")
    val testimonialsLabel: String
)