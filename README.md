## Чтение данных API NASA

Код по [ссылке](https://github.com/A-Sakhmina/netology_javacore_http_nasa-api/blob/master/src/main/java/Main.java)

### Задание

Нужно воспользоваться публичным API NASA и скачать ежедневно выгружаемую им изображение или другой контент (например
видео). Несмотря на то, что API публичный, доступ к нему предоставляется по ключу, который достаточно просто получить по
адресу: https://api.nasa.gov/.

### Описание

Класс [`InfoJson`](https://github.com/A-Sakhmina/netology_javacore_http_nasa-api/blob/master/src/main/java/InfoJson.java)
является описанием класса-ответа от API NASA.

В методе `saveImageFromNasaApi()` происходит скачивание изображения по ссылке, изъятой из поля `url` полученного ответа
от API NASA. Файл скачивается в корень проекта под своим же наименованием.

**Пример** ответа сервиса NASA:

```json 
{
"copyright": "Bill Peters",
"date": "2020-07-17",
"explanation": "After local midnight on July 14 comet NEOWISE was still above the horizon for Goldenrod, Alberta, Canada, just north of Calgary, planet Earth. In this snapshot it makes for an awesome night with dancing displays of the northern lights. The long-tailed comet and auroral displays are beautiful apparitions in the north these days. Both show the influence of spaceweather and the wind from the Sun. Skygazers have widely welcomed the visitor from the Oort cloud, though C/2020 F3 (NEOWISE) is in an orbit that is now taking it out of the inner Solar System.  Comet NEOWISE Images: July 16 | July 15 | July 14 | July 13 | July 12 | July 11 | July 10 & earlier",
"hdurl": "https://apod.nasa.gov/apod/image/2007/DSC1028_PetersNEOWISEAuroralSpike.jpg",
"media_type": "image",
"service_version": "v1",
"title": "NEOWISE of the North",
"url": "https://apod.nasa.gov/apod/image/2007/DSC1028_PetersNEOWISEAuroralSpike_800.jpg"
}
```

Тогда по итогу должен появиться файл `DSC1028_PetersNEOWISEAuroralSpike_800.jpg` в корне проекта.