package com.oluwafemi.trend

import org.gradle.api.artifacts.VersionCatalog


fun VersionCatalog.compileSDK() = this.findVersion("sdkCompile").get().toString().toInt()
fun VersionCatalog.minSDK() = this.findVersion("sdkMin").get().toString().toInt()
fun VersionCatalog.targetSDK() = this.findVersion("sdkTarget").get().toString().toInt()
fun VersionCatalog.versionCode() = this.findVersion("versionCode").get().toString().toInt()
fun VersionCatalog.versionName() = this.findVersion("versionName").get().toString()