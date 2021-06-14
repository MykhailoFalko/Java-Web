<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Beauty Salon</title>
</head>
<body>
<div class="container">
    <div class="col-md-6 mx-auto text-center">
        <div class="header">
            <h1 >
                Check out - it's free!
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 mx-auto">
            <div class="form">
                <form action="controller" method="post" >
                    <input type="hidden" name="command" value="register"/>
                    <div class="form-group">
                        <input type="text" name="login"  class="form-control my-input" id="login" placeholder="Login">
                    </div>
                    <div class="form-group">
                        <input type="email" name="email"  class="form-control my-input" id="email" placeholder="Your@mail.com">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password"  class="form-control my-input" id="password" placeholder="Password">
                    </div>
                    <div class="text-center ">
                        <button type="submit" class=" btn btn-block send-button tx-tfm">Create Your Free Account</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>