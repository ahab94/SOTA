package sota.dto.response

import jota.model.Input

/**
  * Response of {@link jota.dto.request.IotaBroadcastTransactionRequest}.
  **/
case class GetBalancesAndFormatResponse(inputs: List[Input],
                                        totalBalance: Long)