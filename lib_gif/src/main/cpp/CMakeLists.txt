
cmake_minimum_required(VERSION 3.4.1)

#file(GLOB_RECURSE GIF_DIRECTORIES ${CMAKE_SOURCE_DIR}/giflib/*.*)

add_library(
        gif

        SHARED

        PthreadSleep.cpp
        SyncTime.cpp
        GifPlayer.cpp
        GifJni.cpp

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
)

target_link_libraries(
        gif
        jnigraphics
        log
        android)