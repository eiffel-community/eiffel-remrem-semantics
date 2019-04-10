var eventTypes = [
    {
      "number":1,
      "family":"activity",
      "type":"canceled",
      "name":"EiffelActivityCanceledEvent",
      "abbreviation":"ActC",
      "comments":"Available from 0.2.2"
    },
    {
      "number":2,
      "family":"activity",
      "type":"finished",
      "name":"EiffelActivityFinishedEvent",
      "abbreviation":"ActF",
      "comments":"Available from 0.1.9"
    },
    {
      "number":3,
      "family":"activity",
      "type":"started",
      "name":"EiffelActivityStartedEvent",
      "abbreviation":"ActS",
      "comments":"Available from 0.2.2"
    },
    {
      "number":4,
      "family":"activity",
      "type":"triggered",
      "name":"EiffelActivityTriggeredEvent",
      "abbreviation":"ActT",
      "comments":"Available from 0.2.2"
    },
    {
      "number":5,
      "family":"info",
      "type":"announcement",
      "name":"EiffelAnnouncementPublishedEvent",
      "abbreviation":"AnnP",
      "comments":"Available from 0.2.2"
    },
    {
      "number":6,
      "family":"artifact",
      "type":"created",
      "name":"EiffelArtifactCreatedEvent",
      "abbreviation":"ArtC",
      "comments":"Available from 0.2.2"
    },
    {
      "number":7,
      "family":"artifact",
      "type":"published",
      "name":"EiffelArtifactPublishedEvent",
      "abbreviation":"ArtP",
      "comments":"Available from 0.1.9"
    },
    {
      "number":8,
      "family":"artifact",
      "type":"reused",
      "name":"EiffelArtifactReusedEvent",
      "abbreviation":"ArtR",
      "comments":"Available from 0.2.2"
    },
    {
      "number":9,
      "family":"cm",
      "type":"composition",
      "name":"EiffelCompositionDefinedEvent",
      "abbreviation":"CD",
      "comments":"Available from 0.2.2"
    },
    {
      "number":10,
      "family":"artifact",
      "type":"modified",
      "name":"EiffelConfidenceLevelModifiedEvent",
      "abbreviation":"CLM",
      "comments":"Available from 0.2.2"
    },
    {
      "number":11,
      "family":"cm",
      "type":"environment",
      "name":"EiffelEnvironmentDefinedEvent",
      "abbreviation":"ED",
      "comments":"Available from 0.2.2"
    },
    {
      "number":12,
      "family":"flowcontext",
      "type":"defined",
      "name":"EiffelFlowContextDefinedEvent",
      "abbreviation":"FCD",
      "comments":"Available from 0.2.2"
    },
    {
      "number":13,
      "family":"test",
      "type":"issueverified",
      "name":"EiffelIssueVerifiedEvent",
      "abbreviation":"IV",
      "comments":"Available from 0.2.2"
    },
    {
      "number":14,
      "family":"cm",
      "type":"scmchange",
      "name":"EiffelSourceChangeCreatedEvent",
      "abbreviation":"SCC",
      "comments":"Available from 0.2.2"
    },
    {
      "number":15,
      "family":"cm",
      "type":"scmproposedchange",
      "name":"EiffelSourceChangeSubmittedEvent",
      "abbreviation":"SCS",
      "comments":"Available from 0.2.2"
    },
    {
      "number":16,
      "family":"test",
      "type":"canceled",
      "name":"EiffelTestCaseCanceledEvent",
      "abbreviation":"TCC",
      "comments":"Available from 0.2.5"
    },
    {
      "number":17,
      "family":"test",
      "type":"casefinished",
      "name":"EiffelTestCaseFinishedEvent",
      "abbreviation":"TCF",
      "comments":"Available from 0.2.2"
    },
    {
      "number":18,
      "family":"test",
      "type":"casestarted",
      "name":"EiffelTestCaseStartedEvent",
      "abbreviation":"TSS",
      "comments":"Available from 0.2.2"
    },
    {
      "number":19,
      "family":"test",
      "type":"triggered",
      "name":"EiffelTestCaseTriggeredEvent",
      "abbreviation":"TCT",
      "comments":"Available from 0.2.5"
    },
    {
      "number":20,
      "family":"test",
      "type":"execution",
      "name":"EiffelTestExecutionRecipeCollectionCreatedEvent",
      "abbreviation":"TERCC",
      "comments":"Available from 0.2.2"
    },
    {
      "number":21,
      "family":"test",
      "type":"suitefinished",
      "name":"EiffelTestSuiteFinishedEvent",
      "abbreviation":"TSF",
      "comments":"Available from 0.2.2"
    },
    {
      "number":22,
      "family":"test",
      "type":"suitestarted",
      "name":"EiffelTestSuiteStartedEvent",
      "abbreviation":"TSS",
      "comments":"Available from 0.2.2"
    },
    {
      "number":23,
      "family":"artifact",
      "type":"deployed",
      "name":"EiffelArtifactDeployedEvent",
      "abbreviation":"ArtD",
      "comments":"Available from 0.3.2"
    },
    {
      "number":24,
      "family":"service",
      "type":"allocated",
      "name":"EiffelServiceAllocatedEvent",
      "abbreviation":"ServA",
      "comments":"Available from 0.3.2"
    },
    {
      "number":25,
      "family":"service",
      "type":"deployed",
      "name":"EiffelServiceDeployedEvent",
      "abbreviation":"ServDe",
      "comments":"Available from 0.3.2"
    },
    {
      "number":26,
      "family":"service",
      "type":"discontinued",
      "name":"EiffelServiceDiscontinuedEvent",
      "abbreviation":"ServDi",
      "comments":"Available from 0.3.2"
    },
    {
      "number":27,
      "family":"service",
      "type":"returned",
      "name":"EiffelServiceReturnedEvent",
      "abbreviation":"ServR",
      "comments":"Available from 0.3.2"
    },
    {
      "number":28,
      "family":"service",
      "type":"started",
      "name":"EiffelServiceStartedEvent",
      "abbreviation":"ServSta",
      "comments":"Available from 0.3.2"
    },
    {
      "number":29,
      "family":"service",
      "type":"stopped",
      "name":"EiffelServiceStoppedEvent",
      "abbreviation":"ServSto",
      "comments":"Available from 0.3.2"
    },
    {
      "number":30,
      "family":"alert",
      "type":"raised",
      "name":"EiffelAlertRaisedEvent",
      "abbreviation":"AlerR",
      "comments":"Available from 0.3.9"
    },
    {
      "number":31,
      "family":"alert",
      "type":"acknowledged",
      "name":"EiffelAlertAcknowledgedEvent",
      "abbreviation":"AlerA",
      "comments":"Available from 0.3.9"
    },
    {
      "number":32,
      "family":"alert",
      "type":"ceased",
      "name":"EiffelAlertCeasedEvent",
      "abbreviation":"AlerC",
      "comments":"Available from 0.3.9"
    },
    {
      "number":33,
      "family":"test",
      "type":"issuedefined",
      "name":"EiffelIssueDefinedEvent",
      "abbreviation":"IssD",
      "comments":"Available from 2.0.0"
    }
]
