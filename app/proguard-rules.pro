# Preserve line number information for debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If line number information is preserved, hide the original source file name.
-renamesourcefileattribute SourceFile

# Firebase Crashlytics
# Keep annotations and classes extending java.lang.Exception for Crashlytics.
-keepattributes *Annotation*
-keep public class * extends java.lang.Exception
-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**

# Data Classes
# Keep Kotlin data classes and their methods.
-keepclasseswithmembers class com.apoorvgupta.** {
    public ** component1();
    <fields>;
}

# Jetpack Compose Material3
# Keep Jetpack Compose Material3 classes and related packages.
-keep class androidx.compose.material3.** { *; }
-keep class androidx.compose.runtime.** { *; }
-keep class androidx.compose.animation.** { *; }
-keep class androidx.compose.ui.graphics.** { *; }
-keep class androidx.compose.foundation.layout.** { *; }
-keep class androidx.compose.foundation.text.** { *; }
-keep class androidx.compose.material3.icons.** { *; }
-keep class androidx.compose.ui.unit.** { *; }

# Keep resources (R class)
-keepclassmembers class **.R$* {
  public static <fields>;
}

# Keep all annotations
-keepclassmembers class * {
  @com.example.annotationinterface.annotations.* <methods>;
}

# Keep names of fields marked as public static final
-keepclassmembers class * {
    public static final <fields>;
}

# Hilt
# Keep Hilt-related classes and dependencies.
-keep class hilt_aggregated_deps.** {*;}
-keepnames @dagger.hilt.android.lifecycle.HiltViewModel class * extends androidx.lifecycle.ViewModel

# Retrofit
# Keep Retrofit-related classes and annotations.
-keep class retrofit2.** { *; }
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-keepattributes Signature
-keepattributes Exceptions
-keep class kotlin.coroutines.Continuation

# GSON
# Keep GSON-related classes and annotations.
-keepclassmembers,allowobfuscation class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
-keep class com.google.gson.reflect.TypeToken { *; }
-keep class * extends com.google.gson.reflect.TypeToken

# OkHttp
# Keep OkHttp-related classes.
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-keep class okio.** { *; }

# Retrofit and OkHttp annotations
-dontwarn retrofit2.**
-dontwarn okhttp3.**
-dontwarn okio.**

# Project Specific
# Keep project-specific network and model classes.
-keep class com.apoorvgupta.capabilities.network.rest.** {*;}
-keep class com.apoorvgupta.onboarding.login.models.** {*;}
-keep class com.apoorvgupta.** {*;}

# Google Tag Manager
-dontwarn com.google.protobuf.java_com_google_android_gmscore_sdk_target_granule__proguard_group_gtm_N1281923064GeneratedExtensionRegistryLite**
-dontwarn com.apoorvgupta.**