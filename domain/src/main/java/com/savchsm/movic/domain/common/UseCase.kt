package com.savchsm.movic.domain.common

abstract class UseCase<in Params : Any, out Result> {
    abstract suspend fun execute(params: Params): Result
}