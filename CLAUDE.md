# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Maven-based Java 8 snippet library (`com.zane.snippet`) that collects runnable examples of common Java patterns. Topics planned per the Readme: List/Array conversion, Guava usage, Collection sorting, Java 8 Lambdas, Multi-threading, and Design Patterns.

## Build & Run Commands

```bash
# Compile
mvn compile

# Run all tests
mvn test

# Run a single test class
mvn test -Dtest=ClassName

# Package
mvn package

# Run a utility's main() directly (after compiling)
mvn exec:java -Dexec.mainClass="com.zane.snippet.convert.ArrayConvertUtils"
```

## Non-Standard Source Directory Layout

The Maven source directory is configured as `src/main/java` (standard), but the package folders use **dotted directory names** rather than the conventional nested hierarchy:

```
src/main/java/com.zane.snippet/        ← directory named with dots
src/main/java/com.zane.snippet/convert/
src/main/java/com.zane.snippet/guava/
```

This means new packages should be added as subdirectories of `src/main/java/com.zane.snippet/`, not as `src/main/java/com/zane/snippet/`.

## Code Conventions

- Each utility class contains public demonstration methods and a `main()` that calls them all — there are no separate test classes currently.
- Classes use `System.out.println` to show results; JUnit assertions (`Assert.*`) are used inline in `GuavaCollectionUtils` to validate Guava `Strings` behavior.
- Dependencies: **Guava 14.0.1** and **JUnit 4.11** (both available at compile and runtime scope).

## Architecture

The codebase is organized by topic into sub-packages under `com.zane.snippet`:

| Package | Purpose |
|---|---|
| `convert` | Array↔List conversions (fixed-size vs. mutable, primitives, streams) |
| `guava` | Guava helpers: `ImmutableList`/`ImmutableMap`, `Joiner`, `Ints`, `Strings`, `Multimap` |

New topic areas (sort, lambda, threading, patterns) should each get their own sub-package following the same pattern: a utility class with focused public methods and a `main()` that exercises them.
