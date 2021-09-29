plugins {
    id("HappyXPlugin")
    id("com.android.library")
}

android {
    buildTypes {
        release {
        }

        debug {
        }
    }
}

dependencies {

    implementation(libs.android.play.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    testImplementation(libs.junit)
    androidTestImplementation (libs.androidx.test)
    androidTestImplementation (libs.espresso)
}