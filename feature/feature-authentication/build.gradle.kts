@file:Suppress("UnstableApiUsage")
/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    id("kotlin-parcelize")
    id("com.google.devtools.ksp") version ("1.8.0-1.0.9")
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
}

android {
    namespace = "${libs.versions.namespace.get()}.feature.authentication"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.mvi.ui)
    implementation(libs.mvi.processor)
    ksp(libs.mvi.processor)
    api(project(":core:core-component"))
    api(project(":data:data-authentication"))


    implementation(libs.android.material)
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.compose.material)
    implementation(libs.compose.calendar)
    implementation(libs.wheel.picker.compose)
    implementation(libs.coil.compose)
    implementation(libs.navigation.compose)

    with(libs.hilt) {
        implementation(navigation.compose)
        implementation(android)
        androidTestImplementation(android.test)
        kapt(android.compiler)
        kaptTest(android.compiler)
        kapt(compiler)
    }

    with(libs.accompanist) {
        implementation(pager)
        implementation(pager.indicator)
        implementation(flow.layout)
        implementation(shimmer)
    }
    with(libs.gms.play.service) {
        implementation(auth)
        implementation(base)
    }

    with(libs.kotlinx.coroutine) {
        implementation(android)
        implementation(core)
        implementation(play.services)
        testImplementation(test)
    }

    //test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    testImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    testImplementation(libs.robolectric)

    debugImplementation(libs.leak.canary)
}