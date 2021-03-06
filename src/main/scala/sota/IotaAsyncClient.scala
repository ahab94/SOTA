package sota

import com.softwaremill.sttp.SttpBackend
import sota.dto.response.{BroadcastTransactionsResponse, StoreTransactionsResponse}
import sota.exceptions.ArgumentException
import sota.utils.Constants.INVALID_TRYTES_INPUT_ERROR
import sota.utils.InputValidator

import scala.concurrent.{ExecutionContext, Future}
import scala.util.control.NonFatal

class IotaAsyncClient(config: IotaClientConfig = IotaClientConfig(), asyncApiBackend: Option[SttpBackend[Future, Nothing]] = None)
                     (implicit exec: ExecutionContext) extends AsyncCoreAPIs(config, asyncApiBackend) {

  logger.info("SOTA async client spawned for uri:{}", config.iriUrl)

  /**
    * Wrapper function that broadcasts and stores the specified trytes.
    *
    * @param trytes The trytes.
    * @return A StoreTransactionsResponse.
    */
  def broadcastAndStore(trytes: List[String]): Future[StoreTransactionsResponse] = {
    if (!InputValidator.isListOfAttachedTrytes(trytes))
      throw new ArgumentException(INVALID_TRYTES_INPUT_ERROR)
    val broadcastFuture: Future[BroadcastTransactionsResponse] = try broadcastTransactions(trytes) catch {
      case NonFatal(ex) =>
        throw new ArgumentException(ex.getMessage)
    }

    val storeTransactionsFuture = broadcastFuture.flatMap(_ => storeTransactions(trytes))
    storeTransactionsFuture
  }

}
