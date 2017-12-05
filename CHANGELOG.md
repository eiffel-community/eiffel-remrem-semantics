## 0.3.2
- Implemented functionality to support 2.0 eiffel-operations events

## 0.3.1
- Implemented functionality to override input semantics gav with MANIFEST.MF file gav

## 0.3.0
- Implemented routing key for eiffel messages in REMReM semantics.

## 0.2.9
- Implemented functionality to accept case insensitive eventType while generating events

## 0.2.8
- Event names in Eiffel2.0 check and update the eventtype if we haven't passed

## 0.2.7
- Event names in Eiffel2.0 should adhere to documentation of eiffel in Github

## 0.2.6
- Added links validation to events based on the Bordeaux edition of protocol

## 0.2.5
- added copyright headers to the source code

## 0.2.4
- Improved exception handling functionality for event type mismatch

## 0.2.3
- Implemented event specific meta class generation functionality

## 0.2.2
- Implemented family and type functionality for creating RoutingKey in REMREM Semantics.

## 0.2.1
- Implemented build step process to clone eiffel repo,topic-drop4 branch schema's dynamically
- Added functionality for adding properties JavaType and extendJavaType to the cloned schema's to generate pojo's

## 0.2.0
- Implemented pojo's generation from json schemas using jsonSchema2pojo plugin
  we used Eiffel repo,topic-drop4 branch sha_id: 5bc648b4fb906db6c370e35fe45c941462ca18a8
  
  
## 0.1.9
- Implemented getServiceName and added remrem-protocol-interface

## 0.1.8
- added getEventId functionality for get the event id from the json Object

## 0.1.7
- update gradle.build to resolve right version of jackson-databind 
  due to integration conflict of this library with newer versions
  of Spring framework

## 0.1.6
- removed lombok dependecy
- improved logging and error messages to caller
