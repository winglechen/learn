cmake_minimum_required(VERSION 3.8)
project(monitor_object)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp Raii.cpp Raii.h)
add_executable(monitor_object ${SOURCE_FILES})