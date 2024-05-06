import kotlin.Exception

sealed class DataState<T>(
    val data: T?,
    val exception: Exception? = null
) {
    class Success<T>(data: T?) : DataState<T>(data = data)
    class Fail<T>(data: T?, exception: Exception) :
        DataState<T>(data = data, exception = exception)

    fun on(
        onError: (String) -> Unit,
        onSuccess: (T?) -> Unit,
    ) {
        when (this@DataState) {
            is Success -> onSuccess(this@DataState.data)
            else -> handleException(exception) {
                onError(exception.toString())
            }
        }
    }

    private fun handleException(
        exception: Throwable? = null,
        onError: () -> Unit,
    ) {
        exception?.printStackTrace()
        onError()
    }
}