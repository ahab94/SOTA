package sota.dto.request

/**
  * This class represents the core API request 'addNeighbors' and 'removeNeighbors'.
  **/

case class NeighborsRequest(uris: List[String],
                            command: String)
