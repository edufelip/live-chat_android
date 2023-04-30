val ktlintVersion = "0.46.1"

initscript {
    val spotlessVersion = "6.10.0"

    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        classpath("com.diffplug.spotless:spotless-plugin-gradle:$spotlessVersion")
    }
}

allprojects {
    if (this == rootProject) {
        return@allprojects
    }
    apply<com.diffplug.gradle.spotless.SpotlessPlugin>()
    extensions.configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            targetExclude("**/build/**/*.kt")
            ktlint(ktlintVersion).editorConfigOverride(
                mapOf(
                    "ktlint_code_style" to "android",
                    "ij_kotlin_allow_trailing_comma" to true,
                    // These rules were introduced in ktlint 0.46.0 and should not be
                    // enabled without further discussion. They are disabled for now.
                    // See: https://github.com/pinterest/ktlint/releases/tag/0.46.0
                    "disabled_rules" to
                            "filename," +
                            "annotation,annotation-spacing," +
                            "argument-list-wrapping," +
                            "double-colon-spacing," +
                            "enum-entry-name-case," +
                            "multiline-if-else," +
                            "no-empty-first-line-in-method-block," +
                            "package-name," +
                            "trailing-comma," +
                            "spacing-around-angle-brackets," +
                            "spacing-between-declarations-with-annotations," +
                            "spacing-between-declarations-with-comments," +
                            "unary-op-spacing"
                )
            )
        }
        format("kts") {
            target("**/*.kts")
            targetExclude("**/build/**/*.kts")
        }
    }
}