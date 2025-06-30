package ytsmovies.romavicdosanjos.com.core.services.helpers.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> T.toHashMap(): HashMap<String, Any> {
    val gson = Gson()
    val json = gson.toJson(this)
    val type = object : TypeToken<HashMap<String, Any>>() {}.type
    return gson.fromJson(json, type)
}

inline fun <reified T> T.toQueryMap(): Map<String, String> {
    val gson = Gson()
    val json = gson.toJson(this)
    val type = object : TypeToken<Map<String, Any?>>() {}.type
    val rawMap: Map<String, Any?> = gson.fromJson(json, type)

    return rawMap.mapNotNull { (key, value) ->
        value?.toString()?.let { key to it }
    }.toMap()
}
