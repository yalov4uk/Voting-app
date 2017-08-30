# VotingApp

### Fast launch
Environment: docker v17.03, docker-compose v1.16.0-rc2
```
    cd docker
    docker-compose up
```

### Method, Url, Description

#### Topic

_Post_, `api/v1/topics`, create

_Get_, `api/v1/topics/{topicId}`, read

_Put_, `api/v1/topics/{topicId}`, update

_Delete_, `api/v1/topics/{topicId}`, delete

_Delete_, `api/v1/topics`, delete all

_Get_, `api/v1/topics`, get all

##### Body example:
```
{
    "name": "topic"
}
```

#### Voting

_Post_, `api/v1/topics/{topicId}/votings`, create

_Get_, `api/v1/topics/{topicId}/votings/{votingId}`, read

_Put_, `api/v1/topics/{topicId}/votings/{votingId}`, update

_Delete_, `api/v1/topics/{topicId}/votings/{votingId}`, delete

_Delete_, `api/v1/topics/{topicId}/votings`, delete all

_Get_, `api/v1/topics/{topicId}/votings`, get all

_Post_, `api/v1/topics/{topicId}/votings/{votingId}?enable=boolean`, start/close voting

##### Body example:
```
{
    "name": "voting",
    "topicId": 1
}
```

#### Item

_Post_, `api/v1/topics/{topicId}/votings/{votingId}/items`, create

_Get_, `api/v1/topics/{topicId}/votings/{votingId}/items/{itemId}`, read

_Put_, `api/v1/topics/{topicId}/votings/{votingId}/items/{itemId}`, update

_Delete_, `api/v1/topics/{topicId}/votings/{votingId}/items/{itemId}`, delete

_Delete_, `api/v1/topics/{topicId}/votings/{votingId}/items`, delete all

_Get_, `api/v1/topics/{topicId}/votings/{votingId}/items`, get all

_Post_, `api/v1/topics/{topicId}/votings/{votingId}/items/{itemId}`, vote for item

##### Body example:
```
{
    "name": "item",
    "votingId": 1
}
```
