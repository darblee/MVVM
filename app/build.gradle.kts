import java.time.Instant
import java.text.SimpleDateFormat

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.darblee.mvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.darblee.mvvm"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // Generate the Build Time.
            // In the app, you can retreive buidl time info.
            // e.g.     Log.i(TAG, "Build time is " + BuildConfig.BUILD_TIME)
            //          Log.i(TAG, "Build time is " + getString(R.string.build_time))
            val instant = Instant.now()
            val sdf = SimpleDateFormat("MM/dd/yyyy, HH:mm:ss")
            val buildTime = sdf.format(instant.epochSecond * 1000L)
            buildConfigField("String", "BUILD_TIME", "\"${buildTime}\"")
            resValue("string", "build_time", "\"${buildTime}\"")
        }

        debug {

            // Generate the Build Time.
            // In the app, you can retreive buidl time info.
            // e.g.     Log.i(TAG, "Build time is " + BuildConfig.BUILD_TIME)
            //          Log.i(TAG, "Build time is " + getString(R.string.build_time))
            val instant = Instant.now()
            val sdf = SimpleDateFormat("MM/dd/yyyy, HH:mm:ss")
            val buildTime = sdf.format(instant.epochSecond * 1000L)
            buildConfigField("String", "BUILD_TIME", "\"${buildTime}\"")
            resValue("string", "build_time", "\"${buildTime}\"")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0-rc01")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0-rc01")

    // Preference Datastore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")



}