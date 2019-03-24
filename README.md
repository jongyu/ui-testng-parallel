# UI自动化并行测试（Web、iOS、Android）

## 准备Selenium Hub
```bash
docker network create grid
docker run -d -p 4444:4444 --net grid --name selenium-hub selenium/hub:3.141.59-mercury
docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-mercury
docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-firefox:3.141.59-mercury
```

## Get Android Device UDID
```bash
adb device
```

## Get iOS Device UDID
```bash
idevice_id -l
```

## 运行测试
```bash
mvn clean test
```
