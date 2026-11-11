package org.example.composestarter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform