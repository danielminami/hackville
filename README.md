# hackville InterTwine

## BackEnd Rest WebAPI

#### List All Users

```
https://hackville-intertwine.herokuapp.com/user/read
```

#### List Users By Topic

```
https://hackville-intertwine.herokuapp.com/user/getByTopic/{int user id}
```

#### Create New User

```
https://hackville-intertwine.herokuapp.com/user/create
```

Example:

```
{
    "name":"Paul",
    "email":"paul@hotmail.com",
    "location":"google, give me the location please...",
    "age":"+50",
    "gender":"M"
}
```

#### Creat Connection

```
https://hackville-intertwine.herokuapp.com/connection/create/{int user id}
```

Example:

```
{
    "connectionId":1
}

```

#### List Topics

```
https://hackville-intertwine.herokuapp.com/topic/read
```



