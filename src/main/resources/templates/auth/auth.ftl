<!DOCTYPE html>
<html>
<head>
    <title>Animated Login Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
            integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="/js/auth.js"></script>
</head>
<body>
<img class="wave" src="/images/wave.png">
<div class="container">
    <div class="img">
        <img src="img/bg.svg">
    </div>
    <div class="login-content">
        <form  id="loginForm" action="/login" method="post">

            <img src="/images/avatar.svg">
            <h2 class="title">Welcome</h2>
            <div class="input-div one">
                <div class="i">
                    <i class="fas fa-user"></i>
                </div>
                <div class="div">
                        <label for="username" class="sr-only">Username</label>
                        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus="">
                </div>
            </div>
            <div class="input-div pass">
                <div class="i">
                    <i class="fas fa-lock"></i>
                </div>
                <div class="div">
                        <label for="password" class="sr-only">Password</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
                </div>
            </div>
            <input name="_csrf" type="hidden" value="${_csrf.token}">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>
</div>
</body>
</html>
