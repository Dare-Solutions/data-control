import java.util.Properties

plugins {
    id("com.android.application")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

// Clé d'envoi (upload key) pour Google Play. Jamais dans le dépôt : soit
// android/key.properties (sur un poste), soit des variables d'environnement
// (sur GitHub Actions, depuis les secrets). Sans elle, signature de débogage.
val keyProperties = Properties().apply {
    val f = rootProject.file("key.properties")
    if (f.exists()) f.inputStream().use { load(it) }
}
val uploadStoreFile = (keyProperties.getProperty("storeFile") ?: System.getenv("UPLOAD_KEYSTORE_PATH"))
    ?.let { rootProject.file(it) }
    ?.takeIf { it.exists() }
val uploadStorePassword = keyProperties.getProperty("storePassword") ?: System.getenv("UPLOAD_KEYSTORE_PASSWORD")
val uploadKeyAlias = keyProperties.getProperty("keyAlias") ?: System.getenv("UPLOAD_KEY_ALIAS") ?: "flux"
val uploadKeyPassword = keyProperties.getProperty("keyPassword") ?: uploadStorePassword
val hasUploadKey = uploadStoreFile != null && uploadStorePassword != null

android {
    namespace = "com.oseeeb.flux"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    defaultConfig {
        applicationId = "com.oseeeb.flux"
        // You can update the following values to match your application needs.
        // For more information, see: https://flutter.dev/to/review-gradle-config.
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        // Uses the version code from pubspec.yaml. When using split APKs, 1000 * ABI_VERSION
        // is added automatically by Flutter. (https://developer.android.com/studio/build/configure-apk-splits#configure-APK-versions)
        // You can force using the value of versionCode by specifying the `-P force-version-code-ignoring-abi=true`
        // flag during build.
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    signingConfigs {
        if (hasUploadKey) {
            create("upload") {
                storeFile = uploadStoreFile
                storePassword = uploadStorePassword
                keyAlias = uploadKeyAlias
                keyPassword = uploadKeyPassword
            }
        }
    }

    buildTypes {
        release {
            // Clé d'envoi si elle est fournie, sinon clé de débogage (essais).
            signingConfig = signingConfigs.getByName(if (hasUploadKey) "upload" else "debug")
        }
    }
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

flutter {
    source = "../.."
}
