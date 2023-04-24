<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/FishiGames/minecraft-userserver">
    <img src="https://images.mein-mmo.de/medien/2016/05/Minecraft-Header.jpg" alt="Logo">
  </a>

  <p align="center">
    private repository for gameprofiles without ratelimits
    <br />
    <a href="https://github.com/FishiGames/minecraft-userserver/issues"><strong>Report Bug »</strong></a>
    <br />
    <br />
  </p>

## Get user by UUID
```shell
$ curl http://localhost:8443/user/getUserByUniqueId?uniqueId=e0251b43-351c-4318-a742-aa350627df60
{
   "uniqueId":"e0251b43-351c-4318-a742-aa350627df60",
   "username":"FishiGames",
   "value":"ewogICJ0aW1lc3RhbXAiIDogMTY4MjM2NDIyMTAwMiwKICAicHJvZmlsZUlkIiA6ICJlMDI1MWI0MzM1MWM0MzE4YTc0MmFhMzUwNjI3ZGY2MCIsCiAgInByb2ZpbGVOYW1lIiA6ICJGaXNoaUdhbWVzIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzc3MTM5MmUxNTE3MzEzN2MyMDY5NTc3YzFmYTUwMDQ2YTgzYjI5YjJjZTM2YWZiMDRhNjIxNDYxN2UzZjAyMGIiCiAgICB9LAogICAgIkNBUEUiIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzIzNDBjMGUwM2RkMjRhMTFiMTVhOGIzM2MyYTdlOWUzMmFiYjIwNTFiMjQ4MWQwYmE3ZGVmZDYzNWNhN2E5MzMiCiAgICB9CiAgfQp9",
   "signature":"OH6kIZc1JIZ8NgzhRIfTvxXPjB6mEasgXKOPgM9c7zelw4NyFgWpbIyKYk2a/y5p75ye7DIspcnycU0a3h7YmXmEid0Py6qC4ftRwbXzgUzC05Xa10S5xtvy+mJ0zZ+ddQiCY5d7hvDtT+tYEOLXHV2tHgv6qIGoB5PAjYZOcOCmrTo62h9NucNb722eIHMY87zz7ynq6b5C2JpJzkm9VkAx8OxRUBAFp8SKpDkVq31gbW8AaCoofWAvWI+TQrwf616zsstj5hqIY1tICxQQ6xLFqzz9LZ1Vyhk/WWBYNS790TSj5aI8UxlMDwAhxrZqB3wbCDXwpfBEo+pVYEOOtobYGh5QsyM1S7iUI3XlQWx2fNYbiOeLi07NuZCw6np+YTl2zxui31arwOluaTNBmFbgShbIVxmVS3xk+Sn0KgRY1CBTKBNpJcNuDUY/dAabm7NRB1jCt6H4pN+pDgnOq3yYOBNQIoXez273HfEGrTDm6BUnqLne7vpGVe5iBzSRKVqZWzyyIQB9fGBs15+9E5cUKxKJLfOJpO/oP3b+OJUtDNAIjGk+Jc6fDz731yMFJF7cur2BBHUshRYuK/9vlGZavX2ZnWZfAPufTTKi2FsdYlsZRWODohaxUwKfilcTVZpUoHhRO3L95l5s7s376JkKpkqAVmOdTOO2Llx5XSc="
}

```
## Get user by Name
```shell
$ curl localhost:8443/user/getUserByUserName?username=FishiGames
{
   "uniqueId":"e0251b43-351c-4318-a742-aa350627df60",
   "username":"FishiGames",
   "value":"ewogICJ0aW1lc3RhbXAiIDogMTY4MjM2NDIyMTAwMiwKICAicHJvZmlsZUlkIiA6ICJlMDI1MWI0MzM1MWM0MzE4YTc0MmFhMzUwNjI3ZGY2MCIsCiAgInByb2ZpbGVOYW1lIiA6ICJGaXNoaUdhbWVzIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzc3MTM5MmUxNTE3MzEzN2MyMDY5NTc3YzFmYTUwMDQ2YTgzYjI5YjJjZTM2YWZiMDRhNjIxNDYxN2UzZjAyMGIiCiAgICB9LAogICAgIkNBUEUiIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzIzNDBjMGUwM2RkMjRhMTFiMTVhOGIzM2MyYTdlOWUzMmFiYjIwNTFiMjQ4MWQwYmE3ZGVmZDYzNWNhN2E5MzMiCiAgICB9CiAgfQp9",
   "signature":"OH6kIZc1JIZ8NgzhRIfTvxXPjB6mEasgXKOPgM9c7zelw4NyFgWpbIyKYk2a/y5p75ye7DIspcnycU0a3h7YmXmEid0Py6qC4ftRwbXzgUzC05Xa10S5xtvy+mJ0zZ+ddQiCY5d7hvDtT+tYEOLXHV2tHgv6qIGoB5PAjYZOcOCmrTo62h9NucNb722eIHMY87zz7ynq6b5C2JpJzkm9VkAx8OxRUBAFp8SKpDkVq31gbW8AaCoofWAvWI+TQrwf616zsstj5hqIY1tICxQQ6xLFqzz9LZ1Vyhk/WWBYNS790TSj5aI8UxlMDwAhxrZqB3wbCDXwpfBEo+pVYEOOtobYGh5QsyM1S7iUI3XlQWx2fNYbiOeLi07NuZCw6np+YTl2zxui31arwOluaTNBmFbgShbIVxmVS3xk+Sn0KgRY1CBTKBNpJcNuDUY/dAabm7NRB1jCt6H4pN+pDgnOq3yYOBNQIoXez273HfEGrTDm6BUnqLne7vpGVe5iBzSRKVqZWzyyIQB9fGBs15+9E5cUKxKJLfOJpO/oP3b+OJUtDNAIjGk+Jc6fDz731yMFJF7cur2BBHUshRYuK/9vlGZavX2ZnWZfAPufTTKi2FsdYlsZRWODohaxUwKfilcTVZpUoHhRO3L95l5s7s376JkKpkqAVmOdTOO2Llx5XSc="
}
```

<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/FishiGames/minecraft-userserver/issues) for a list of proposed features (and known issues).


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.
\
This API is unofficial, and we are in no way affiliated with Mojang Studios.


<!-- CONTACT -->
## Contact

Twitter - [@FishiGames](https://twitter.com/FishiGames)
\
YouTube - [@FishiGames](https://www.youtube.com/@FishiGames)
\
Twitch - [@FishiGamesXD](https://twitch.tv/FishiGamesXD)
\
Project: [https://github.com/FishiGames/minecraft-userserver](https://github.com/FishiGames/minecraft-userserver)
