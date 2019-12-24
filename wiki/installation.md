## Installation

This project does not need any installation. It is used as external library that will be included as a dependency to other projects.

This project is build by maven, by executing following commands:

`mvn clean install`

The produced jar file will be stored in /eiffel-remrem-semantics/target/

To update the schemas in semantics with latest changes in Eiffel Operation repo schemas execute the maven profile **process-schemas** like below

`mvn clean install -P process-schemas`

By executing the process-schemas profile you will get the latest schemas from both eiffel repository and eiffel-operations repository.

After updating the schemas execute the profile **generate-events** to generate pojo clases by using updated schemas.

`mvn clean install -P generate-events`

### Note:

Execute the above mentioned maven profiles in order what they were declared if there is any change in schemas of eiffel or eiffel-operations repository.

Eiffel REMReM Semantics maintained by [EiffelCommunity](https://github.com/eiffel-community)