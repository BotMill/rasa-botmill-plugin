[![Build Status](https://travis-ci.org/BotMill/rasa-botmill-plugin.svg?branch=master)](https://travis-ci.org/BotMill/rasa-botmill-plugin)

# RASA-BotMill - RASA NLU/NLP Plugin for BotMill Libraries

A Simple Java Library to access RASA NLU HTTP Endpoints for BotMill.

Features:

- Authorization
- Access /parse, /train and /status
- Java Object Model from Json Endpoint Response

Setup

```java
//	setup your connection (url and token)
RasaBotMillContext.configure().setup("http://127.0.0.1:5000","123456789");

//	Call the Parse http endpoint
Response resp = RasaService.sendParseRequest("How are you?");

//	Call Training endpoint
TrainingResponse resp = RasaService.sendTrainRequest(jsonObject.toString()); 
TrainingResponse resp = RasaService.sendTrainFileRequest(<new File("")>);

//	Call the status endpoint.
Response status = RasaService.getStatus(); 
```

Get Response Entities via Response and Training Objects
```java
Response resp = RasaService.sendParseRequest("How are you?");
resp.getIntent();
resp.getEntities(); // list of entities
resp.getText();

TrainingResponse resp = RasaService.sendTrainRequest(jsonObject.toString()); 
resp.getInfo();
```

<sub>Copyright (c) 2016-2017 BotMill.io</sub>
