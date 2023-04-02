package com.example.myapplication

import com.example.common.BuildService
import com.google.auto.service.AutoService

@AutoService(BuildService::class)
class BuildServiceImpl() : BuildService {
    override fun versionCode(): Int {
        return 1
    }
}