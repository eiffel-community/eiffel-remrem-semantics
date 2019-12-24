## Routing and Binding key concepts

Eiffel protocol uses RabbitMQ as a message broker. It accepts and forwards messages. You can think about it as a post office: when you put the mail that you want posting in a post box, you can be sure that Mr. Postman will eventually deliver the mail to your recipient. In this analogy, RabbitMQ is a post box, a post office and a postman.

Each message in RabbitMQ must be posted to one or more exchanges. A binding is a relationship between an exchange and a queue. This can be simply read as: the queue is interested in messages from this exchange. The routing algorithm behind an exchange is simple - a message goes to the queues whose binding key exactly matches the routing key of the message.

An exchange is responsible for the routing of the messages to the different queues. An exchange accepts messages from the producer application and routes them to message queues with help of header attributes, bindings and routing keys.

A binding is a "link" that you set up to bind a queue to an exchange.

The routing key is a message attribute. The exchange might look at this key when deciding how to route the message to queues (depending on exchange type).

Topic exchanges route messages to queues based on wildcard matches between the routing key and something called the routing pattern specified by the queue binding. Messages are routed to one or many queues based on a matching between a message routing key and this pattern.

The routing key must be a list of words, delimited by a period (.), examples are "eiffel.activity.#" and "eiffel.activity.started.#". All of these routing keys will match the event that comes with a tag "eiffel.activity.started.notag" which in this case identifies event that is produced by eiffel protocol, the event family is activity, the event type is started. The routing patterns may contain an asterisk ("*") to match a word in a specific position of the routing key (e.g. a routing pattern of "eiffel.*.*.notag.#" will only match routing keys where the first word is "eiffel" and the fourth word is "notag"). A pound symbol ("#") indicates match on zero or more words (e.g. a routing pattern of "eiffel.artifact.#" matches any routing keys beginning with "eiffel.artifact").

The consumers indicate which topics they are interested in (like subscribing to a feed for an individual tag). The consumer creates a queue and sets up a binding with a given routing pattern to the exchange. All messages with a routing key that match the routing pattern will be routed to the queue and stay there until the consumer consumes the message.

## Eiffel routing convention

The routing key is concatenated from five entities: the event protocol, family, the event type, any custom tag and domain  
The routing key format for Eiffel REMReM Semantics:

`eiffel.<family>.<type>.<tag>.<domain>`

*   <family> is a family name for a group of events, e.g. "activity".
*   <type> represents the event, e.g. "triggered".
*   <tag> is a field which carries no meaning for Eiffel itself, but may be used by users to implement a custom categorization scheme on which message routing may be applied. The tag must NOT contain any dots, as this will deny the receiver the ability to anticipate the word sequence of the binding key and must not exceed 16 characters in length. It is reserved for future use. Defaults to "notag".
*   <domain> The domain from which the message is sent. The value of the domain will fetch from Eiffel event if empty the value is fetch from the remrem publish configuration. domain can be suffixed by a user domain part that the user can specify with -ud option. For more information on domain, see [this link](https://github.com/eiffel-community/eiffel/blob/master/eiffel-syntax-and-usage/the-meta-object.md#metasourcedomainid).

The routing key for EiffelArtifactCreatedEvent would be eiffel.artifact.created.notag.eiffeltestdomain.sweden.rem002

##Limitation

The maximum limit for RabbitMQ routing key is 255 characters and as an Eiffel product we reserve some characters to form the binding /routing keys.

Eiffel REMReM Semantics maintained by [EiffelCommunity](https://github.com/eiffel-community)
