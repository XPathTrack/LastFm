plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.refactor.lastfm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.refactor.lastfm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "V0.003"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.github.glide)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}