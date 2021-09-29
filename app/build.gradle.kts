plugins {
    id("HappyXPlugin")
    id("com.android.application")
}

happyPlugin {
    buildConfigGeneration = true
    viewBinding = true
}

android {
    buildTypes {
        release {
        }

        debug {
        }
    }

    dynamicFeatures += setOf(
        ":feature_reader"
    )
}

dependencies {
    implementation(libs.android.play.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.android.material)
    implementation(libs.android.play.core.ktx)
    implementation(libs.kodein.generic)
    implementation(libs.kodein.framework)
    implementation(libs.viewbinding.delegates)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.navigation.dynamic.features)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test)
    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.navigation.testing)
}
