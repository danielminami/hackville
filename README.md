# hackville InterTwine

## BackEnd Rest Docs

#### List All Users

```
http://localhost:8080/user/read
```

#### List Users By Topic

```
http://localhost:8080/user/getByTopic/{int user id}
```

#### Create New User

```
http://localhost:8080/user/create
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
http://localhost:8080/connection/create/{int user id}
```

Example:

```
{
    "connectionId":1
}

```

#### List Topics

```
http://localhost:8080/topic/read
```



