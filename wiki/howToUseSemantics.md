## How to use semantics

To import the project, add below mentioned dependencies in pom.xml.

    <repositories>
       <repository>
           <id>jitpack.io</id>
           <url>https://jitpack.io</url>
       </repository>
    </repositories>
    <dependency>
        <groupId>com.github.eiffel-community</groupId>
        <artifactId>eiffel-remrem-semantics</artifactId>
        <version>x.x.x</version>
    </dependency>

Or add below mentioned dependencies to gradle build script.

    repositories {
         ...
         maven { url 'https://jitpack.io' }
    }
    dependencies {
        compile("com.github.eiffel-community:eiffel-remrem-semantics:x.x.x")
    }

Eiffel REMReM Semantics contains implementation of Eiffel REMReM Protocol Interface. All methods of interface MsgService are implemented by SemanticsService class: generateMsg, getEventId, getEventType, getSupportedEventTypes, getEventTemplate, getServiceName, validateMsg, generateRoutingKey. Also in this class could be implemented more methods depending on the needs of developer.

The main task of Eiffel Semantics is to check a correctness of Eiffel message. Project contains JSON schemas for each Eiffel event type. If you need to create new event type, you need to define the JSON schema for this event.

Each of Eiffel data types, for example links, gav, etc have its implementation in schema. If you need to extend event with some custom field, the JSON schema for this field and serializer should be created for it. Also event JSON schema need to be updated.

During the verification process input JSON for SemanticsService is updated with the protocol related fields, for example id.

All Eiffel events consist of 3 logical JSON objects: meta, data and links. The meta object contains meta-information describing the event: when it was created, where it came from, its type etc. The data object contains all fields specific to the event type – the payload of the event – including trace links to non-Eiffel entities. It is described in detail per event type. The links object is an array of trace links to other Eiffel events.
Please refer [Eiffel Remrem Protocol Interface](https://github.com/eiffel-community/eiffel-remrem-protocol-interface) to get more information on event types.

## Messages Table

Refer [Event-Templates](templates.md) of current official Eiffel events along with their templates.

Eiffel REMReM Semantics maintained by [EiffelCommunity](https://github.com/eiffel-community)