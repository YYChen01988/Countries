# Memexpress
Display random memes from https://meme-api.herokuapp.com/gimme/wholesomememes/50 (https://github.com/D3vd/Meme_Api)

# 1. Core
This can be accessed by all modules. Inludes utils and abstractions.

# 2. app
With main application and injections and access to all modules. 

# 3. memes
Provides list of memes and the titles

## Gradle

# 1. config-android.gradle
    - Contains android configuration. Enabled viewbinding and buildvariants. Flavors needs to be added here and this will be accessed by all libraries build.gradles

# 2. config-properties.gradle
    - Contains properties that needs to be secured. BASE_URL in this code.

# 3. dependencies-all.gradle
    - Dependencies.


# Libraries
1. Koin(DI)
2. Android Architecture (AndroidX,ViewModel,navigation, Lifecycle, LiveData, Coroutines)
4. Glide 4.12.0
5. Retrofit2, OkHttp, Gson
6. Mockito
7. Junit
8. Ktlint
