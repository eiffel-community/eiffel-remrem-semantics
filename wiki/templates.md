### Templates 
This page shows the event types and their templates.Templates for Eiffel events to be used with [REMReM Generate](https://github.com/eiffel-community/eiffel-remrem-generate) are found below.

Template can be downloaded and all fields labeled as required are mandatory to fill.
Templates are available from eiffel-remrem-semantics-0.2.5 version.

Templates are in full JSON syntax and filenames are in lowercase from eiffel-remrem-semantics-0.3.5 version.

You can download the templates and use them in REMReM generate.

| S.No   |  Family |  Type |  Name |  Abbrevation | Comments |
|:----------:|:-------------:|:------:|:-----:|:----:|:-----:|
| 1 | activity | canceled | [EiffelActivityCanceledEvent](../src/main/resources/templates/eiffelactivitycanceledevent.json) | ActC | Available from 0.2.2 |
| 2 | activity | finished | [EiffelActivityFinishedEvent](../src/main/resources/templates/eiffelactivityfinishedevent.json) | ActF | Available from 0.1.9 |
| 3 | activity | started | [EiffelActivityStartedEvent](../src/main/resources/templates/eiffelactivitystartedevent.json) | ActS | Available from 0.2.2 |
| 4 | activity | triggered | [EiffelActivityTriggeredEvent](../src/main/resources/templates/eiffelactivitytriggeredevent.json) | ActT | Available from 0.2.2 |
| 5 | announcement | info | [EiffelAnnouncementPublishedEvent](../src/main/resources/templates/eiffelannouncementpublishedevent.json) | AnnP | Available from 0.2.2 |
| 6 | artifact | created | [EiffelArtifactCreatedEvent](../src/main/resources/templates/eiffelartifactcreatedevent.json) | ArtC | Available from 0.2.2 |
| 7 | artifact | published | [EiffelArtifactPublishedEvent](../src/main/resources/templates/eiffelartifactpublishedevent.json) | ArtP | Available from 0.2.2 |
| 8 | artifact | reused | [EiffelArtifactReusedEvent](../src/main/resources/templates/eiffelartifactreusedevent.json) | ArtR | Available from 0.2.2 |
| 9 | cm | composition | [EiffelCompositionDefinedEvent](../src/main/resources/templates/eiffelcompositiondefinedevent.json) | CD | Available from 0.2.2 |
| 10 | artifact | modified | [EiffelConfidenceLevelModifiedEvent](../src/main/resources/templates/eiffelconfidencelevelmodifiedevent.json) | CLM | Available from 0.2.2 |
| 11 | cm | environment | [EiffelEnvironmentDefinedEvent](../src/main/resources/templates/eiffelenvironmentdefinedevent.json) | ED | Available from 0.2.2 |
| 12 | flowcontext | defined | [EiffelFlowContextDefinedEvent](../src/main/resources/templates/eiffelflowcontextdefinedevent.json) | FCD | Available from 0.2.2 |
| 13 | test | issueverified | [EiffelIssueVerifiedEvent](../src/main/resources/templates/eiffelissueverifiedevent.json) | IV | Available from 0.2.2 |
| 14 | cm | scmchange | [EiffelSourceChangeCreatedEvent](../src/main/resources/templates/eiffelsourcechangecreatedevent.json) | SCC | Available from 0.2.2 |
| 15 | cm | scmproposedchange | [EiffelSourceChangeSubmittedEvent](../src/main/resources/templates/eiffelsourcechangesubmittedevent.json) | SCS | Available from 0.2.2 |
| 16 | test | canceled | [EiffelTestCaseCanceledEvent](../src/main/resources/templates/eiffeltestcasecanceledevent.json) | TCC | Available from 0.2.5 |
| 17 | test | casefinished | [EiffelTestCaseFinishedEvent](../src/main/resources/templates/eiffeltestcasefinishedevent.json) | TCF | Available from 0.2.2 |
| 18 | test | casestarted | [EiffelTestCaseStartedEvent](../src/main/resources/templates/eiffeltestcasestartedevent.json) | TSS | Available from 0.2.2 |
| 19 | test | triggered | [EiffelTestCaseTriggeredEvent](../src/main/resources/templates/eiffeltestcasetriggeredevent.json) | TCT | Available from 0.2.5 |
| 20 | test | execution | [EiffelTestExecutionRecipeCollectionCreatedEvent](../src/main/resources/templates/eiffeltestexecutionrecipecollectioncreatedevent.json) | TERCC | Available from 0.2.2 |
| 21 | test | suitefinished | [EiffelTestSuiteFinishedEvent](../src/main/resources/templates/eiffeltestsuitefinishedevent.json) | TSF | Available from 0.2.2 |
| 22 | test | suitestarted | [EiffelTestSuiteStartedEvent](../src/main/resources/templates/eiffeltestsuitestartedevent.json) | TSS | Available from 0.2.2 |
| 23 | artifact | deployed | [EiffelArtifactDeployedEvent](../src/main/resources/templates/eiffelartifactdeployedevent.json) | ArtD | Available from 0.3.2 |
| 24 | service | allocated | [EiffelServiceAllocatedEvent](../src/main/resources/templates/eiffelserviceallocatedevent.json) | ServA | Available from 0.3.2 |
| 25 | service | deployed | [EiffelServiceDeployedEvent](../src/main/resources/templates/eiffelservicedeployedevent.json) | ServDe | Available from 0.3.2 |
| 26 | service | discontinued | [EiffelServiceDiscontinuedEvent](../src/main/resources/templates/eiffelservicediscontinuedevent.json) | ServDi | Available from 0.3.2 |
| 27 | service | returned | [EiffelServiceReturnedEvent](../src/main/resources/templates/eiffelservicereturnedevent.json) | ServR | Available from 0.3.2 |
| 28 | service | started | [EiffelServiceStartedEvent](../src/main/resources/templates/eiffelservicestartedevent.json) | ServSta | Available from 0.3.2 |
| 29 | service | stopped | [EiffelServiceStoppedEvent](../src/main/resources/templates/eiffelservicestoppedevent.json) | ServSto | Available from 0.3.2 |
| 30 | alert | raised | [EiffelAlertRaisedEvent](../src/main/resources/templates/eiffelalertraisedevent.json) | AlerR | Available from 0.3.9 |
| 31 | alert | acknowledged | [EiffelAlertAcknowledgedEvent](../src/main/resources/templates/eiffelalertacknowledgedevent.json) | AlerA | Available from 0.3.9 |
| 32 | alert | ceased | [EiffelAlertCeasedEvent](../src/main/resources/templates/eiffelalertceasedevent.json) | AlerC | Available from 0.3.9 |
| 33 | test | issuedefined | [EiffelIssueDefinedEvent](../src/main/resources/templates/eiffelissuedefinedevent.json) | IssD | Available from 2.0.0 |
