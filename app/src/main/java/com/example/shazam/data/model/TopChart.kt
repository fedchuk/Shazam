package com.example.shazam.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TopChart(
    val id: String,
    val type: String,
    val layout: String,
    val title: String,
    val url: String,
    val apple_music_url: String,
    val subtitle: String,
    val images: Images?,
    val share: Share,
    val hub: Hub,
    val artists: List<Artists>
)

@Serializable
data class Images(
    val background: String,
    val coverart: String?,
    val coverarthq: String,
    val joecolor: String
)

@Serializable
data class Share(
    val subject: String,
    val text: String,
    val href: String,
    val image: String,
    val twitter: String,
    val html: String,
    val snapchat: String
)

@Serializable
data class Hub(
    val type: String,
    val image: String,
    val actions: List<Actions>,
    val options: List<Options>,
    val explicit: String,
    val displayname: String
)

@Serializable
data class Actions(
    val name: String,
    val type: String,
    val id: String
)

@Serializable
data class Options(
    val caption: String,
    val actions: List<Actions>,
    val beacondata: Beacondata,
    val image: String,
    val type: String,
    val listcaption: String,
    val overflowimage: String,
    val colouroverflowimage: Boolean,
    val providername: String
)

@Serializable
data class Beacondata(
    val type: String,
    val providername: String
)

@Serializable
data class Artists(
    val follow: Follow,
    val alias: String,
    val id: String
)

@Serializable
data class Follow(
    val followkey: String
)
