package com.example.getcontent.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val interceptedRequest: Request = chain.request()

        val request: Request = interceptedRequest.newBuilder()
            .header(KEY_ACCEPT, "application/json")
            //.header(KEY_AUTHORIZATION, "nRGGB7bhCOSbaJeSkhYSDix-cWju7XsP7zTjt1XTFG0")
            .method(interceptedRequest.method, interceptedRequest.body)
            .build()

        return chain.proceed(request)
    }

    companion object {
        private const val KEY_ACCEPT = "Accept"
        private const val KEY_AUTHORIZATION = "token"
    }
}