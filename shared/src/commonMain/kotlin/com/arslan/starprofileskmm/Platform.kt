package com.arslan.starprofileskmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform