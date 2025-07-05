<h1 align="center">News-shots Android Application</h1>
<p align="center">
<a href="#">
<img alt="Android OS" src="https://img.shields.io/badge/OS-Android-3DDC84?style=flat-square&logo=android">
</a>
<a href="#">
<img alt="Android OS" src="https://flat.badgen.net/badge/Language/Kotlin?icon=https://raw.githubusercontent.com/binaryshrey/Awesome-Android-Open-Source-Projects/master/assets/Kotlin_Logo_icon_white.svg&color=f18e33">
</a>
</p>
<br>

----
### Contents ###
- Jetpack Compose
- Product Flavors
- MVI (Model-View-Intent) Clean Architecture
- Hilt DI (Dependency Injection)
- Reusable Modules
    - Network Module
        - REST: Retrofit + OKHttp
- Data Storage Module
    - SharedPreferences
    - Datastore
- Navigation Components
    - Tabs
    - Toolbar
    - Drawer
- Common Utilities
- Logger
- Unit Test Library - MockK, JUnit
- MBaaS Capabilities: Firebase
    - Remote Configuration
    - Crashlytics
    - Performance Monitoring
    - Analytics
    - Push Notifications
- CI/CD using Github Actions

----
### Newsshots Architecture Overview ###

#### Clean Architecture ####
##### Core #####
The Core module is the foundational layer of your application. It consists of components and functionalities that are considered essential, universal, and stable. These components are less likely to undergo frequent changes, providing a stable and reliable base for the entire application. The purpose of the Core module is to establish a set of fundamental building blocks that can be leveraged across the application without significant modifications.

##### Capabilities #####
The Capabilities module groups together shared capabilities that are crucial for building the application. These capabilities might include functionalities related to networking, presentation, and utilities that are needed across different features. The goal is to create a modular and reusable set of tools that can be easily integrated into various parts of the application.

##### Features #####
Feature modules represent specific functionalities or components within the application. Each feature is designed to encapsulate a standalone piece of user-facing functionality. Features can be thought of as self-contained units, allowing for modularity, maintainability, and ease-of development.

##### App #####
The App module acts as the orchestrator, bringing together all the different elements of the application. It serves as the integration point for Core components, shared Capabilities, and individual Features. The App module is responsible for combining these elements to construct the final application. This module is where you define the overall structure, dependencies, and interactions between different parts of the application. The App module ensures that the Core functionalities are available, shared Capabilities are accessible, and individual Features are integrated to create a cohesive and functional Android application.

#### Folder Structure ####

```
app

... features
└── onboarding
└── home

...... capabilities
    └── network
         └── graphql
         └── rest
    └── presentation
         └── navigation
         └── reusable-ui-components
         └── theme
    └── util
    
......... core
        └── base
        └── exception-handlers
        └── gobal-constants
        └── logger
        └── global-models
        └── storage
...............
```

#### Application Architecture ####
##### MVI #####

<p align="center">
<img width="580px" src="https://blog.mindorks.com/images/mvi_cyclic-49d9f8c2d3fe26b7.png" alt="aaosp"></img></p>

MVI (Model-View-Intent) architecture is a reactive architecture pattern.

Key benefits:
1. Unidirectional Data Flow
2. Immutability
3. Single Source of Truth
4. Predictable State Changes
5. Testability
6. Separation of Concerns
7. Scalability

----
### Requirements ###
- Android Studio Hedgehog | 2023.1.1
- Target API: 34 (Android 14 Upside Down Cake)
- Gradle: 8.2
- Android application plugin : 'com.android.application:8.2.0'
- Android library plugin: 'com.android.library:8.2.0'
- Kotlin: 1.9.21
- JVM Target Version: 17

----
### Uses ###

<p align="center">
<a href="#">
<img alt="Ktlint" src="https://img.shields.io/badge/ktlint%20code--style-%E2%9D%A4-FF4081">
</a>
<a href="#">
<img alt="Retrofit" src="https://flat.badgen.net/badge/Networking/Retrofit">
</a>
<a href="#">
<img alt="Firebase" src="https://img.shields.io/badge/Google-Firebase-yellow">
</a>
</p>

----
### Licenses ###
MIT License

```
Copyright (c) 2025, Apoorv Gupta.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

----
### Get in touch ###

[Apoorv Gupta](mailto:apurvagupta45@gmail.com)
