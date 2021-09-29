plugins {
    id("HappyXPlugin")
    id("com.android.dynamic-feature")
}

happyPlugin {
    viewBinding = true
}

dependencies {
    implementation(projects.app)
    implementation(projects.csvParser)
    implementation(projects.commons)
    implementation(libs.android.play.core.ktx)
    implementation(libs.kodein.generic)
    implementation(libs.kodein.framework)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.navigation.dynamic.features)
    implementation(libs.viewbinding.delegates)
    implementation(libs.paging)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test)
    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.espresso.contrib)
}