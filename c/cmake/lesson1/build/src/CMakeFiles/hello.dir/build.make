# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.3

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/local/Cellar/cmake/3.3.2/bin/cmake

# The command to remove a file.
RM = /usr/local/Cellar/cmake/3.3.2/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /www/learn/c/cmake/lesson1

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /www/learn/c/cmake/lesson1/build

# Include any dependencies generated for this target.
include src/CMakeFiles/hello.dir/depend.make

# Include the progress variables for this target.
include src/CMakeFiles/hello.dir/progress.make

# Include the compile flags for this target's objects.
include src/CMakeFiles/hello.dir/flags.make

src/CMakeFiles/hello.dir/hello.o: src/CMakeFiles/hello.dir/flags.make
src/CMakeFiles/hello.dir/hello.o: ../src/hello.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/www/learn/c/cmake/lesson1/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object src/CMakeFiles/hello.dir/hello.o"
	cd /www/learn/c/cmake/lesson1/build/src && /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc  $(C_DEFINES) $(C_FLAGS) -o CMakeFiles/hello.dir/hello.o   -c /www/learn/c/cmake/lesson1/src/hello.c

src/CMakeFiles/hello.dir/hello.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/hello.dir/hello.i"
	cd /www/learn/c/cmake/lesson1/build/src && /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc  $(C_DEFINES) $(C_FLAGS) -E /www/learn/c/cmake/lesson1/src/hello.c > CMakeFiles/hello.dir/hello.i

src/CMakeFiles/hello.dir/hello.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/hello.dir/hello.s"
	cd /www/learn/c/cmake/lesson1/build/src && /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc  $(C_DEFINES) $(C_FLAGS) -S /www/learn/c/cmake/lesson1/src/hello.c -o CMakeFiles/hello.dir/hello.s

src/CMakeFiles/hello.dir/hello.o.requires:

.PHONY : src/CMakeFiles/hello.dir/hello.o.requires

src/CMakeFiles/hello.dir/hello.o.provides: src/CMakeFiles/hello.dir/hello.o.requires
	$(MAKE) -f src/CMakeFiles/hello.dir/build.make src/CMakeFiles/hello.dir/hello.o.provides.build
.PHONY : src/CMakeFiles/hello.dir/hello.o.provides

src/CMakeFiles/hello.dir/hello.o.provides.build: src/CMakeFiles/hello.dir/hello.o


# Object files for target hello
hello_OBJECTS = \
"CMakeFiles/hello.dir/hello.o"

# External object files for target hello
hello_EXTERNAL_OBJECTS =

../bin/hello: src/CMakeFiles/hello.dir/hello.o
../bin/hello: src/CMakeFiles/hello.dir/build.make
../bin/hello: src/CMakeFiles/hello.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/www/learn/c/cmake/lesson1/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable ../../bin/hello"
	cd /www/learn/c/cmake/lesson1/build/src && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/hello.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
src/CMakeFiles/hello.dir/build: ../bin/hello

.PHONY : src/CMakeFiles/hello.dir/build

src/CMakeFiles/hello.dir/requires: src/CMakeFiles/hello.dir/hello.o.requires

.PHONY : src/CMakeFiles/hello.dir/requires

src/CMakeFiles/hello.dir/clean:
	cd /www/learn/c/cmake/lesson1/build/src && $(CMAKE_COMMAND) -P CMakeFiles/hello.dir/cmake_clean.cmake
.PHONY : src/CMakeFiles/hello.dir/clean

src/CMakeFiles/hello.dir/depend:
	cd /www/learn/c/cmake/lesson1/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /www/learn/c/cmake/lesson1 /www/learn/c/cmake/lesson1/src /www/learn/c/cmake/lesson1/build /www/learn/c/cmake/lesson1/build/src /www/learn/c/cmake/lesson1/build/src/CMakeFiles/hello.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : src/CMakeFiles/hello.dir/depend

