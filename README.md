# Tiny URL Service
Spring Boot Project to generate Tiny Url and Use that URL to redirect to the original URL
## Spring Boot: 3.2.3
## Java Version: 21
## Databases Used: MySQL
## Cache: Redis

Tracking is added to get all the required analytics of the hits (How many hits and Time of hits)

## Curl Commands:

### Generate Tiny Url
curl --location --request POST 'http://localhost:8085/tinyUrl/v1/create?originalUrl=https%3A%2F%2Fwww.google.com%2Fsearch%3Fq%3Dcomposite%2Bdesign%2Bpattern%2Bto%2Beliminate%2Bmultiple%2Bif%2Belse%26oq%3Dcomposite%2Bdesign%2Bpattern%2Bto%2Beliminate%2B%26gs_lcrp%3DEgZjaHJvbWUqBwgBECEYoAEyBggAEEUYOTIHCAEQIRigATIHCAIQIRigATIHCAMQIRigAdIBCDg4NjJqMGo3qAIAsAIA%26sourceid%3Dchrome%26ie%3DUTF-8'

### Fetch Tiny Url Details by Original Url
curl --location 'http://localhost:8085/tinyUrl/v1/fetch?originalUrl=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DI0czvJ_jikg%26list%3DRDI0czvJ_jikg%26start_radio%3D1'

### Track the Hits Without Time Limit
curl --location 'http://localhost:8085/tinyUrl/v1/track?trackingParameter=TINY_URL&url=http%3A%2F%2Flocalhost%3A8085%2FtinyUrl%2F1XvbV'

### Track the Hits between given time and now
curl --location 'http://localhost:8085/tinyUrl/v1/track?trackingParameter=TINY_URL&url=http%3A%2F%2Flocalhost%3A8085%2FtinyUrl%2F1XvbV&startTime=2024-03-03T04%3A03%3A54'

### Track the Hits between start time and end time
curl --location 'http://localhost:8085/tinyUrl/v1/track?trackingParameter=TINY_URL&url=http%3A%2F%2Flocalhost%3A8085%2FtinyUrl%2F1XvbV&startTime=2024-03-03T04%3A03%3A54&endTime=2024-03-03T04%3A03%3A55'

## Happy Coding Folks!!