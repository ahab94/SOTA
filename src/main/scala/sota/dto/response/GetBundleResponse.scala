package sota.dto.response

import sota.models.Transaction

/**
  * Response of api request 'getBundle'.
  **/
case class GetBundleResponse(transactions: List[Transaction],
                             duration: Long)
