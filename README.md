## Our Goals:
   * Find a REST framework which allows the following:
        * Minimal TTM
        * Easy to develop and maintain
        * Reduce boilerplate code
        * Configurable
        * Allows our developers to focus on their job instead of trying to understand why code broke down
        * Easy integration with SSO
        * Enable secure & insecure endpoints
        * Monitoring
        * Logging
        * Well documentation online
    
   * One direction - server to client:
        * Send a message via kafka producer to a relevant topic
        * Consume the message via a kafka consumer
        * Allow users to get the information using a REST endpoint
        * Sounds easy? we would like to set up a generic kafka consumer with the generic server, and then using runtime
        reflection from Avro to JSON, pass the data to REST endpoint.
   * Second direction - client to server:
        * Post data to the server, via REST endpoint. 
        * Server should set a producer via configuration, translating from JSON to the specific Avro type
        * the consumer should be able to get expected data
        
  * Level 2:
       * SSO -> secured and insecure endpoints
       * Logging 
       * Monitoring
       * Testability
       * Running in containers
       * Runtime speed     
          