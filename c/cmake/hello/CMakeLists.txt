cmake_minimum_required (VERSION 3.3)
project (Hello)

MESSAGE(STATUS "This is BINARY dir " ${Hello_BINARY_DIR})
MESSAGE(STATUS "This is SOURCE dir " ${Hello_SOURCE_DIR})
add_executable(Hello hello.c)
