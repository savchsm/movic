package com.savchsm.movic.domain.base

abstract class UseCase<in Params : Any, out Result> {
    abstract suspend fun execute(params: Params): Result
}