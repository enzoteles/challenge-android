package br.com.desafio.util

/**
 * Created by Enzo Teles on 04/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

enum class StatusCodes {
    HTTP200, //OK
    HTTP400, //BAD REQUEST
    HTTP401, //UNAUTHORIZED
    HTTP403, //FORBIDDEN
    HTTP404, //NOT FOUND
    HTTP500, //INTERNAL SERVER ERROR
    HTTP502, //BAD GATEWAY
    HTTP503, //SERVICE UNAVAILABLE
    HTTP520  //UNKNOWN ERROR
}


object HttpStatusCodes{
    fun errorStatusCode(code: Int) =  when(code){
            StatusCodes.HTTP400 as Int -> "BAD REQUEST"
            StatusCodes.HTTP401 as Int -> "UNAUTHORIZED"
            StatusCodes.HTTP403 as Int -> "FORBIDDEN"
            StatusCodes.HTTP404 as Int -> "NOT FOUND"
            StatusCodes.HTTP500 as Int -> "INTERNAL SERVER ERROR"
            StatusCodes.HTTP502 as Int -> "BAD GATEWAY"
            StatusCodes.HTTP503 as Int -> "SERVICE UNAVAILABLE"
            StatusCodes.HTTP520 as Int -> "UNKNOWN ERROR"
            else -> "Not Error"
        }
}