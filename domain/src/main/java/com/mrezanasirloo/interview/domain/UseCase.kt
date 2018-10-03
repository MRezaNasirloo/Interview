package com.mrezanasirloo.interview.domain

abstract class UseCase<P, R> {
    abstract fun execute(parameter: P): R
}