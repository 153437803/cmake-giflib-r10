# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

#添加一个库，根据native-lib.cpp源文件编译一个native-lib的动态库
add_library( # Sets the name of the library.
        giflib
        # Sets the library as a shared library.
        SHARED

        #播放GIF
        giflib/config.h
        giflib/dgif_lib.c
        giflib/egif_lib.c
        giflib/gif_err.c
        giflib/gif_font.c
        giflib/gif_hash.c
        giflib/gif_hash.h
        giflib/gif_lib.h
        giflib/gif_lib_private.h
        giflib/gifalloc.c
        giflib/openbsd-reallocarray.c
        giflib/quantize.c

        # Provides a relative path to your source file(s).
        gif_load.cpp)


# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        giflib

        # Links the target library to the log library
        # included in the NDK.
        log
        jnigraphics
        )