plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

}

android {
    namespace = "com.example.betterto_do"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.betterto_do"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")
    implementation("com.google.firebase:firebase-auth-ktx:22.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation ("com.google.firebase:firebase-analytics:21.5.0")
    implementation ("com.firebaseui:firebase-ui-auth:7.2.0")
    implementation ("androidx.compose.ui:ui:1.5.4")
    implementation ("androidx.compose.foundation:foundation:1.5.4")
    implementation ("androidx.compose.material:material:1.5.4")


    //implementation ("androidx.compose.ui:ui:$compose_version")
    //implementation ("androidx.compose.ui:ui-tooling-preview:$compose_version")
    //androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    //androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    //androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$compose_version")
    //debugImplementation ("androidx.compose.ui:ui-tooling:$compose_version")
    //debugImplementation ("androidx.compose.ui:ui-test-manifest:$compose_version")
    //def room_version = "2.6.0"
    //implementation ("androidx.room:room-runtime:$room_version")
    //implementation ("androidx.room:room-ktx:$room_version")
    //implementation ("androidx.compose.runtime:runtime-livedata:1.5.4")
    //annotationProcessor ("androidx.room:room-compiler:$room_version")
    //kapt ("androidx.room:room-compiler:$room_version")
    //implementation ("androidx.core:core-splashscreen:1.0.1")
    //implementation ("androidx.datastore:datastore-preferences:1.0.0")
    //def lottieVersion = "6.0.0"
    //implementation ("com.airbnb.android:lottie-compose:$lottieVersion")
}