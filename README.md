# VotingApp

### Fast launch
Environment: docker v17.03, docker-compose v1.16.0-rc2
```
    cd docker
    docker-compose up
```

Server starts at port 8081

### Method, Url, Description

#### Topic

_Post_, `api/v1/topics`, create

_Get_, `api/v1/topics/{topicId}`, read

_Put_, `api/v1/topics/{topicId}`, update

_Delete_, `api/v1/topics/{topicId}`, delete

_Get_, `api/v1/topics`, get all

_Delete_, `api/v1/topics`, delete all

##### Request body example:
```
{
    "name": "topic"
}
```

#### Voting

_Post_, `api/v1/votings`, create

_Get_, `api/v1/votings/{votingId}`, read

_Put_, `api/v1/votings/{votingId}`, update

_Delete_, `api/v1/votings/{votingId}`, delete

_Get_, `api/v1/votings`, get all

_Delete_, `api/v1/votings`, delete all

_Post_, `api/v1/topics/{topicId}/votings`, create by topicId

_Get_, `api/v1/topics/{topicId}/votings`, get all by topicId

_Delete_, `api/v1/topics/{topicId}/votings`, delete all by topicId

_Post_, `api/v1/votings/{votingId}?enable=boolean`, start/close voting

##### Request body example:
```
{
    "name": "voting",
    "topicId": 1
}
```

#### Item

_Post_, `api/v1/items`, create

_Get_, `api/v1/items/{itemId}`, read

_Put_, `api/v1/items/{itemId}`, update

_Delete_, `api/v1/items/{itemId}`, delete

_Get_, `api/v1/items`, get all

_Delete_, `api/v1/items`, delete all

_Delete_, `api/v1/topics/{topicId}/votings/{votingId}/items`, delete all by topicId and votingId

_Get_, `api/v1/topics/{topicId}/votings/{votingId}/items`, get all by topicId and votingId

_Post_, `api/v1/topics/{topicId}/votings/{votingId}/items`, create by topicId and votingId

_Post_, `api/v1/topics/{topicId}/votings/{votingId}/items/{itemId}`, vote for item

##### Request body example:
```
{
    "name": "item",
    "votingId": 1
}
```
