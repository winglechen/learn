cmake_minimum_required(VERSION 3.8)
project(cpphello)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp hello/world.cpp hello/Hello.cpp hello/Hello.h)
add_executable(cpphello ${SOURCE_FILES})