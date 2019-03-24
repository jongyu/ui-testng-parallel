# Selenium并行测试

## 准备Selenium Hub
```bash
docker network create grid
docker run -d -p 4444:4444 --net grid --name selenium-hub selenium/hub:3.141.59-mercury
docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-mercury
docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-firefox:3.141.59-mercury
```

## Gen Android Device UDID
```bash
adb device
```

## 运行测试
```bash
mvn clean test
```
