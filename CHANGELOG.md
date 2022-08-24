## 2.2.3
- Uplifted eiffel-remrem-parent version from 2.0.7 to 2.0.8.
- Uplifted eiffel-remrem-protocol-interface version from 2.1.2 to 2.1.3.

## 2.2.2
- After schema update process,implemented code changes to prepend copyright header to generated POJO classes.
- Uplifted httpclient dependency version.
- Uplifted eiffel-remrem-parent version from 2.0.6 to 2.0.7.
- Removed the jstl-api dependency to resolve the /context_path issue.

## 2.2.1
- Uplifted eiffel-remrem-parent version from 2.0.5 to 2.0.6.

## 2.2.0
- Updated schemas to match the Paris edition of the protocol.
- Provided implementation for getProtocolEdition() method which returns the edition name
- Uplifted eiffel-remrem-protocol-interface version from 2.1.1 to 2.1.2.

## 2.1.1
- Uplifted eiffel-remrem-parent version from 2.0.4 to 2.0.5.
- Uplifted eiffel-remrem-protocol-interface version from 2.1.0 to 2.1.1.

## 2.1.0
- Updated REMReM Generate to support lenient validation for Eiffel Semantics protocol.

## 2.0.13
- Removed the validation of REMReM should not accept both a CAUSE and a CONTEXT link types in the same event.

## 2.0.12
- Added link types PARTIALLY_RESOLVED_ISSUE, RESOLVED_ISSUE and DERESOLVED_ISSUE in EiffelSourceChangeCreatedEvent.

## 2.0.11
- Uplifted eiffel-remrem-parent version from 2.0.3 to 2.0.4
- Uplifted eiffel-remrem-protocol-interface version from 2.0.3 to 2.0.4.

## 2.0.10
- Uplifted eiffel-remrem-parent version from 2.0.2 to 2.0.3.
- Uplifted eiffel-remrem-protocol-interface version from 2.0.2 to 2.0.3.

## 2.0.9
- Moved REMReM Semantics documentation from gh-pages to master branch.

## 2.0.8
- Handled NullPointerException in SemanticService for missing fields.

## 2.0.7
- Added the link types FAILED_ISSUE,INCONCLUSIVE_ISSUE and SUCCESSFUL_ISSUE in IssueVerified event.

## 2.0.6
- Uplifted eiffel-remrem-parent version from 2.0.1 to 2.0.2.
- Uplifted eiffel-remrem-protocol-interface version from 2.0.1 to 2.0.2.

## 2.0.5
- Uplifted eiffel-remrem-parent version from 2.0.0 to 2.0.1.
- Uplifted eiffel-remrem-protocol-interface version from 2.0.0 to 2.0.1.

## 2.0.4
- Updated couple of events in templates

## 2.0.3
- Updated generate event time to system UTC.
- Updated edition-agen to edition-agen-1 to fetch latest security updates.

## 2.0.2
- Fixed issues when generating events because of false check for semantics purl or not.

## 2.0.1
- Parent group changed from Ericsson to eiffel-community.

## 2.0.0
- Changed templates of all events in Agen format.

## 1.0.1
- Changed Link from http://ericsson.github.io to https://eiffel-community.github.io.
- Upgraded eiffel-remrem-protocol-interface version from 1.0.0 to 1.0.1.

## 1.0.0
- Upgraded eiffel-remrem-parent version from 0.0.8 to 1.0.0.
- Upgraded eiffel-remrem-protocol-interface version from 0.0.14 to 1.0.0.

## 0.5.3
- Upgraded eiffel-remrem-parent version from 0.0.7 to 0.0.8.
- Upgraded eiffel-remrem-protocol-interface version from 0.0.13 to 0.0.14.

## 0.5.2
- Upgraded eiffel-remrem-parent version from 0.0.6 to 0.0.7.
- Upgraded eiffel-remrem-protocol-interface version from 0.0.12 to 0.0.13.

## 0.5.1
- Added changes to allow valid eiffel link types only while generating eiffel events
- Uplifted eiffel-remrem-parent version from 0.0.5 to 0.0.6

## 0.5.0
- Updated eiffel-remrem-protocol-interface version and REMReM Parent version

## 0.4.9
- Updated eiffel-remrem-protocol-interface version

## 0.4.8
- Updated parent version

## 0.4.7
- Updated parent version and added maven assembly plugin to make it fat jar

## 0.4.6
- Migrated from gradle to maven

## 0.4.5
- Implemented code changes which avoids the generation of duplicate class names.

## 0.4.4
- Minor changes in mockito dependency availablity.

## 0.4.3
- Updated dependencies versions

## 0.4.2
- Removed serializer information from few event templates which are missed in the previous release

## 0.4.1
- Removed unwanted dependencies

## 0.4.0
- Removed extra fields from templates and updated version

## 0.3.9
- Generated event epoch time is in UTC format only 

- Generated eiffel events using Toulouse edition of eiffel and operations-extension schemas

## 0.3.8
- added logback dependency

## 0.3.7
- Updated templates to resolve json parsing issues

## 0.3.6
- Updated semantics templates and removed unnecessary validation exception message to find out the issue quickly

## 0.3.5
- Changed the way template files are read and parsed in getEventTemplate method.

## 0.3.4
- Implemented method to get template from specified event type.

## 0.3.3
- Implemented method to get supported event types.

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
